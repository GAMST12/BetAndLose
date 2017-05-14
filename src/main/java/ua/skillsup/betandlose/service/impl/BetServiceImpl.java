package ua.skillsup.betandlose.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.betandlose.dao.*;
import ua.skillsup.betandlose.filter.AuthFilter;
import ua.skillsup.betandlose.model.*;
import ua.skillsup.betandlose.model.enumeration.Event;
import ua.skillsup.betandlose.model.enumeration.Sex;
import ua.skillsup.betandlose.model.message.ResponseMessage;
import ua.skillsup.betandlose.service.BetService;
import ua.skillsup.betandlose.service.additional.CheckingData;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Service
public class BetServiceImpl implements BetService{
    private static final Logger log = Logger.getLogger(BetServiceImpl.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private BetDao betDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private TournamentDao tournamentDao;
    @Autowired
    private KindSportDao kindSportDao;



    @Override
    public ResponseMessage createNewUser(String login, String password, String email, String firstName, String lastName) {
        UserDto checkUser =  userDao.findByLogin(login);
        if (Objects.isNull(checkUser) && !CheckingData.checkAnyStringsIsEmpty(login, password, email, firstName, lastName)) {
            UserDto newUserDto = new UserDto();
            newUserDto.setLogin(login);
            newUserDto.setPassword(password);
            newUserDto.setEmail(email);
            newUserDto.setFirstName(firstName);
            newUserDto.setLastName(lastName);
            newUserDto.setLoginDate(LocalDate.now());
            newUserDto.setOkv(BigDecimal.valueOf(0.0));
            newUserDto.setRole("U");
            userDao.create(newUserDto);
            log.info("Create new user: " + login);
            return ResponseMessage.okMessage(null);
        }
        log.error("Can't create new user: " + login + " " + email + " " + firstName + " " + lastName);
        return ResponseMessage.errorMessage("Wrong user data!");
    }

    @Override
    public ResponseMessage addBet(String login, long itemDtoId, String event, BigDecimal koef, BigDecimal sum) {
        UserDto userDto =  userDao.findByLogin(login);
        ItemDto itemDto = itemDao.findById(itemDtoId);
        if (Objects.nonNull(userDto) && sum.doubleValue()>0 && Objects.nonNull(itemDto) && userDto.getOkv().doubleValue() >=  sum.doubleValue()) {
            BetDto betDto = new BetDto();
            betDto.setItemDto(itemDto);
            betDto.setUserDto(userDto);
            betDto.setBetDate(LocalDate.now());
            betDto.setEvent(Event.valueOf(event));
            betDto.setKoef(koef);
            betDto.setBetSum(sum);
            betDto.setBetResultSum(BigDecimal.valueOf(0.0));
            betDto.setFinished(false);
            betDao.create(betDto);
            log.info("Add new bet: " + betDto.getBetDate() + " " +
                    betDto.getItemDto().getId() + " " + betDto.getUserDto().getLogin() + " " + betDto.getBetSum());
            userDto.setOkv(BigDecimal.valueOf(userDto.getOkv().doubleValue() - sum.doubleValue()));
            userDao.update(userDto);
            return ResponseMessage.okMessage(null);
        }
        log.error("Can't add new bet: user - " + login + ", itemId - " + itemDto.getId());
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @Override
    public ResponseMessage addItem(LocalDate itemDate, long tournamentId, long homeTeamId, long awayTeamId, BigDecimal koefWin1, BigDecimal koefDraw, BigDecimal koefWin2) {
        if (!CheckingData.checkAnyNumbersIsEmpty(koefWin1, koefDraw, koefWin2) && itemDate.isAfter(LocalDate.now().minusDays(1))
                && homeTeamId != awayTeamId) {

            ItemDto itemDto = new ItemDto();
            itemDto.setItemDate(itemDate);
            itemDto.setTournamentDto(tournamentDao.findById(tournamentId));
            itemDto.setHomeTeamDto(teamDao.findById(homeTeamId));
            itemDto.setAwayTeamDto(teamDao.findById(awayTeamId));
            itemDto.setWin1Koef(koefWin1);
            itemDto.setDrawKoef(koefDraw);
            itemDto.setWin2Koef(koefWin2);
            itemDto.setHomeScore(0);
            itemDto.setAwayScore(0);
            itemDto.setFinished(false);
            itemDao.create(itemDto);
            log.info("Add new item: " + itemDate + " " + tournamentId
                    + " " + homeTeamId + " " + awayTeamId + " " + koefWin1 + " " + koefDraw + " " + koefWin2);
            return ResponseMessage.okMessage(null);
        }
        log.error("Can't add new item: " + itemDate + " " + tournamentId
                    + " " + homeTeamId + " " + awayTeamId + " " + koefWin1 + " " + koefDraw + " " + koefWin2);
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @Override
    public ResponseMessage addKindSport(String kindSport) {
        KindSportDto checkKindSport =  kindSportDao.findBySport(kindSport);
        if (Objects.isNull(checkKindSport) &&  !CheckingData.checkAnyStringsIsEmpty(kindSport)) {
            KindSportDto newKindSportDto = new KindSportDto();
            newKindSportDto.setSport(kindSport);
            kindSportDao.create(newKindSportDto);
            log.info("Add new kind of sport: " + kindSport);
            return ResponseMessage.okMessage(null);
        }
        log.info("Can't add new kind of sport: " + kindSport);
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @Override
    public ResponseMessage auth(String login, String password, HttpSession session) {
        UserDto userDto =  userDao.findByLogin(login);
        if (Objects.nonNull(userDto) &&  userDto.getLogin().equals(login)
                && userDto.getPassword().equals(password)) {
            session.setAttribute(AuthFilter.AUTH_ATTR_DATE, LocalDateTime.now());
            session.setAttribute(AuthFilter.AUTH_ATTR_LOGIN, login);
            session.setAttribute(AuthFilter.AUTH_ATTR_ROLE, userDto.getRole());
            log.info("Authentification success: " + login);
            return ResponseMessage.okMessage(null);
        }
        log.error("Authentification failed: " + login);
        return ResponseMessage.errorMessage("Wrong credentials!");

    }

    @Override
    public ResponseMessage addResult(long itemId, int homeScore, int awayScore) {
        ItemDto itemDto = itemDao.findById(itemId);
        List<BetDto> betDtoList = betDao.findByItem(itemDto);

        if (Objects.nonNull(itemDto) && !CheckingData.checkAnyNumbersIsEmpty(homeScore, awayScore)) {
            itemDto.setHomeScore(homeScore);
            itemDto.setAwayScore(awayScore);
            itemDto.setFinished(true);
            itemDao.update(itemDto);

            if (Objects.nonNull(betDtoList)) {
                for (BetDto betDto : betDtoList) {
                    betDto.setFinished(true);
                    betDao.update(betDto);
                    if ((betDto.getEvent().equals(Event.WIN1) && homeScore > awayScore)
                            || (betDto.getEvent().equals(Event.WIN2) && homeScore < awayScore)
                            || (betDto.getEvent().equals(Event.DRAW) && homeScore == awayScore)) {
                        betDto.setBetResultSum(BigDecimal.valueOf(betDto.getBetSum().doubleValue() * betDto.getKoef().doubleValue()));
                        UserDto userDto = betDto.getUserDto();
                        userDto.setOkv(BigDecimal.valueOf(userDto.getOkv().doubleValue() + (betDto.getBetSum().doubleValue() * betDto.getKoef().doubleValue())));
                        userDao.update(userDto);
                        betDao.update(betDto);
                    }

                }
            }
            log.info("Add result for item: " + " id - " + itemId + " - " +homeScore + ":" + awayScore);
            return ResponseMessage.okMessage(null);
        }
        log.error("Can't add result for item: " + " id - " + itemId + " - " + homeScore + ":" + awayScore);
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @Override
    public ResponseMessage addTeam(String team, String city, String country, String sex, String kindSport) {
        TeamDto checkTeam =  teamDao.findByTeamCityCountrySex(team, city, country, sex);
        if (Objects.isNull(checkTeam) && !CheckingData.checkAnyStringsIsEmpty(team, city, country, sex, kindSport)) {
            TeamDto newTeamDto = new TeamDto();
            newTeamDto.setTeam(team);
            newTeamDto.setCity(city);
            newTeamDto.setCountry(country);
            newTeamDto.setSex(Sex.valueOf(sex));
            newTeamDto.setSportDto(kindSportDao.findBySport(kindSport));
            teamDao.create(newTeamDto);
            log.info("Add new team: " + team + " (" + city + ", " + country + ", " + sex + ")" + ": " + kindSport );
            return ResponseMessage.okMessage(null);
        }
        log.error("Can't add new team: " + team + " (" + city + ", " + country + ", " + sex + ")" + ": " + kindSport);
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @Override
    public ResponseMessage addTournament(String tournament, String kindSport) {
        TournamentDto checkTournament =  tournamentDao.findByTournament(tournament);
        if (Objects.isNull(checkTournament) &&  !CheckingData.checkAnyStringsIsEmpty(tournament, kindSport)) {
            TournamentDto tournamentDto = new TournamentDto();
            tournamentDto.setTournament(tournament);
            tournamentDto.setSportDto(kindSportDao.findBySport(kindSport));
            tournamentDao.create(tournamentDto);
            log.info("Add new tournament: " + tournament + ": " + kindSport );
            return ResponseMessage.okMessage(null);
        }
        log.error("Can't add new tournament: " + tournament + ": " + kindSport );
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @Override
    public ResponseMessage deposit(String login, BigDecimal sum) {
        UserDto userDto = userDao.findByLogin(login);
        if (Objects.nonNull(userDto) && !CheckingData.checkAnyNumbersIsEmpty(sum)) {
                        userDto.setOkv(BigDecimal.valueOf(userDto.getOkv().doubleValue() + (sum.doubleValue())));
                        userDao.update(userDto);
            log.info("Add deposit for account: " + " login - " + login + ", sum - " +sum);
            return ResponseMessage.okMessage(null);
        }
        log.error("Can't add deposit for account: " + " login - " + login + ", sum - " + sum);
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @Override
    public ResponseMessage withdraw(String login, BigDecimal sum) {
        UserDto userDto = userDao.findByLogin(login);
        if (Objects.nonNull(userDto) && !CheckingData.checkAnyNumbersIsEmpty(sum)
                && (userDto.getOkv().doubleValue() - (sum.doubleValue()))>=0) {
            userDto.setOkv(BigDecimal.valueOf(userDto.getOkv().doubleValue() - (sum.doubleValue())));
            userDao.update(userDto);
            log.info("Withdraw from account: " + " login - " + login + ", sum - " +sum);
            return ResponseMessage.okMessage(null);
        }
        log.error("Can't withdraw from account: " + " login - " + login + ", sum - " + sum);
        return ResponseMessage.errorMessage("Wrong data!");

    }

}


