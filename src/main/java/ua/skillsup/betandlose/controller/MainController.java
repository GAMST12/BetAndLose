package ua.skillsup.betandlose.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.betandlose.dao.*;
import ua.skillsup.betandlose.filter.AuthFilter;
import ua.skillsup.betandlose.model.*;
import ua.skillsup.betandlose.model.additional.*;
import ua.skillsup.betandlose.model.auth.Credentials;
import ua.skillsup.betandlose.model.enumeration.Event;
import ua.skillsup.betandlose.model.enumeration.Sex;
import ua.skillsup.betandlose.model.filter.ItemFilter;
import ua.skillsup.betandlose.model.message.ResponseMessage;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Controller
public class MainController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BetDao betDao;
    @Autowired
    private KindSportDao kindSportDao;
    @Autowired
    private TournamentDao tournamentDao;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private ItemDao itemDao;





    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationPage() {
        return "/registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage createNewUser(@RequestBody UserDto userDto) {
        UserDto checkUser =  userDao.findByLogin(userDto.getLogin());
        if (Objects.isNull(checkUser) &&  userDto.getLogin()!=null
                && userDto.getPassword() != null && userDto.getFirstName() != null
                && userDto.getLastName() != null && userDto.getEmail() != null) {
            userDto.setLoginDate(LocalDate.now());
            userDto.setOkv(BigDecimal.valueOf(0.0));
            userDto.setOkv(BigDecimal.valueOf(1000.0));
            userDto.setRole("U");
            userDao.create(userDto);
            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong user data!");
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage auth(@RequestBody Credentials credentials,
                       HttpServletRequest request) {
        UserDto userDto =  userDao.findByLogin(credentials.getLogin());
        if (Objects.nonNull(userDto) &&  userDto.getLogin().equals(credentials.getLogin())
                && userDto.getPassword().equals(credentials.getPassword())) {
            request.getSession()
                    .setAttribute(AuthFilter.AUTH_ATTR_DATE, LocalDateTime.now());
            request.getSession()
                    .setAttribute(AuthFilter.AUTH_ATTR_LOGIN, credentials.getLogin());
            request.getSession()
                    .setAttribute(AuthFilter.AUTH_ATTR_ROLE, userDto.getRole());
            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong credentials!");
    }


    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(Model model, HttpServletRequest request) {
        model.addAttribute("userDto", userDao.findByLogin((String) request.getSession().getAttribute(AuthFilter.AUTH_ATTR_LOGIN)));
        model.addAttribute("betDto", betDao.findByUser(userDao.findByLogin((String) request.getSession().getAttribute(AuthFilter.AUTH_ATTR_LOGIN))));
        return "/profile";
    }

    @RequestMapping(value = "/adminprofile", method = RequestMethod.GET)
    public String getAdminProfile(Model model, HttpServletRequest request) {
        model.addAttribute("userDto", userDao.findByLogin((String) request.getSession().getAttribute(AuthFilter.AUTH_ATTR_LOGIN)));
        return "/adminprofile";
    }

    @RequestMapping(value = "/addkindsport", method = RequestMethod.GET)
    public String getAddKindSport(Model model, HttpServletRequest request) {
        return "/addkindsport";
    }


    @RequestMapping(value = "/kindSport", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addKindSport(@RequestBody KindSportDto kindSportDto) {
        KindSportDto checkKindSport =  kindSportDao.findBySport(kindSportDto.getSport());
        if (Objects.isNull(checkKindSport) &&  kindSportDto.getSport() != null &&  kindSportDto.getSport() != "") {
            kindSportDao.create(kindSportDto);
            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @RequestMapping(value = "/addtournament", method = RequestMethod.GET)
    public String getAddTournament(Model model, HttpServletRequest request) {
        model.addAttribute("kindSportDto", kindSportDao.findAll());
        return "/addtournament";
    }

    @RequestMapping(value = "/tournament", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addTournament(@RequestBody AddingTournament addingTournament) {
        TournamentDto checkTournament =  tournamentDao.findByTournament(addingTournament.getTournament());
        if (Objects.isNull(checkTournament) &&  addingTournament.getTournament() != null
                && addingTournament.getKindSport() != null && addingTournament.getTournament() != ""
                && addingTournament.getKindSport() != "") {
            TournamentDto tournamentDto = new TournamentDto();
            tournamentDto.setTournament(addingTournament.getTournament());
            tournamentDto.setSportDto(kindSportDao.findBySport(addingTournament.getKindSport()));
            System.out.println(tournamentDto);
            tournamentDao.create(tournamentDto);
            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @RequestMapping(value = "/addteam", method = RequestMethod.GET)
    public String getAddTeam(Model model, HttpServletRequest request) {
        model.addAttribute("kindSportDto", kindSportDao.findAll());
        model.addAttribute("sexList", Sex.getAllSex());
        return "/addteam";
    }


    @RequestMapping(value = "/team", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addTeam(@RequestBody AddingTeam addingTeam) {
        System.out.println(addingTeam.getTeam() + " " + addingTeam.getCity() + " " + addingTeam.getCountry()
                + " " + addingTeam.getSex() + " " + addingTeam.getKindSport());
        TeamDto checkTeam =  teamDao.findByTeamCityCountrySex(addingTeam.getTeam(), addingTeam.getCity(), addingTeam.getCountry(), addingTeam.getSex());
        if (Objects.isNull(checkTeam)
                &&  addingTeam.getTeam() != null && addingTeam.getTeam() != ""
                && addingTeam.getCity() != null && addingTeam.getCity() != ""
                && addingTeam.getCountry() != null && addingTeam.getCountry() != ""
                && addingTeam.getSex() != null && addingTeam.getSex() != "") {
            TeamDto teamDto = new TeamDto();
            teamDto.setTeam(addingTeam.getTeam());
            teamDto.setCity(addingTeam.getCity());
            teamDto.setCountry(addingTeam.getCountry());
            teamDto.setSex(Sex.valueOf(addingTeam.getSex()));
            teamDto.setSportDto(kindSportDao.findBySport(addingTeam.getKindSport()));
            System.out.println(teamDto);
            teamDao.create(teamDto);
            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @RequestMapping(value = "/additem", method = RequestMethod.GET)
    public String getAddItem(Model model, HttpServletRequest request) {
        model.addAttribute("tournamentDto", tournamentDao.findAll());
        model.addAttribute("teamDto", teamDao.findAll());
        return "/additem";
    }


    @RequestMapping(value = "/item", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addItem(@RequestBody AddingItem addingItem) {
        System.out.println(addingItem.getDate() + " " + addingItem.getTournament()
                + " " + addingItem.getHomeTeam() + " " + addingItem.getAwayTeam()
                + " " + addingItem.getKoefWin1() + " " + addingItem.getKoefDraw()
                + " " + addingItem.getKoefDraw());
        if ( addingItem.getDate() != null
                && addingItem.getTournament() != null && addingItem.getTournament() != ""
                && addingItem.getHomeTeam() != null && addingItem.getHomeTeam() != ""
                && addingItem.getAwayTeam() != null && addingItem.getAwayTeam() != ""
                && addingItem.getKoefWin1() != null
                && addingItem.getKoefDraw() != null
                && addingItem.getKoefWin2() != null
                && addingItem.getHomeTeam() != addingItem.getAwayTeam()) {

            String homeTeam = addingItem.getHomeTeam().substring(0,addingItem.getHomeTeam().indexOf("("));
            String homeCity = addingItem.getHomeTeam().substring(addingItem.getHomeTeam().indexOf("(")+1,addingItem.getHomeTeam().indexOf(","));
            String homeCountry = addingItem.getHomeTeam().substring(addingItem.getHomeTeam().indexOf(",")+1,addingItem.getHomeTeam().indexOf(";"));
            String homeSex = addingItem.getHomeTeam().substring(addingItem.getHomeTeam().indexOf(";")+1,addingItem.getHomeTeam().indexOf(")"));

            System.out.println(homeTeam + " " + homeCity + " " + homeCountry + " " + homeSex);

            String awayTeam = addingItem.getAwayTeam().substring(0, addingItem.getAwayTeam().indexOf("("));
            String awayCity = addingItem.getAwayTeam().substring(addingItem.getAwayTeam().indexOf("(")+1,addingItem.getAwayTeam().indexOf(","));
            String awayCountry = addingItem.getAwayTeam().substring(addingItem.getAwayTeam().indexOf(",")+1,addingItem.getAwayTeam().indexOf(";"));
            String awaySex = addingItem.getAwayTeam().substring(addingItem.getAwayTeam().indexOf(";")+1,addingItem.getAwayTeam().indexOf(")"));

            System.out.println(awayTeam + " " + awayCity + " " + awayCountry + " " + awaySex);

            ItemDto itemDto = new ItemDto();
            itemDto.setItemDate(addingItem.getDate());
            itemDto.setTournamentDto(tournamentDao.findByTournament(addingItem.getTournament()));
            itemDto.setHomeTeamDto(teamDao.findByTeamCityCountrySex(homeTeam, homeCity, homeCountry, homeSex));
            itemDto.setAwayTeamDto(teamDao.findByTeamCityCountrySex(awayTeam, awayCity, awayCountry, awaySex));
            itemDto.setWin1Koef(addingItem.getKoefWin1());
            itemDto.setDrawKoef(addingItem.getKoefDraw());
            itemDto.setWin2Koef(addingItem.getKoefWin2());
            itemDto.setHomeScore(0);
            itemDto.setAwayScore(0);
            itemDto.setFinished(false);
            System.out.println(itemDto);
            itemDao.create(itemDto);
            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @RequestMapping(value = "/betting", method = RequestMethod.GET)
    public String bettingPage(Model model, HttpServletRequest request) {
            ItemFilter itemFilter =  new ItemFilter();
            itemFilter.setDateItemFrom(LocalDate.now());
            model.addAttribute("userDto", userDao.findByLogin((String) request.getSession().getAttribute(AuthFilter.AUTH_ATTR_LOGIN)));
            model.addAttribute("itemDto", itemDao.findByFilter(itemFilter));
        return "/betting";
    }


    @RequestMapping(value = "/bet", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addBet(@RequestBody AddingBet addingBet,
                                HttpServletRequest request) {
        UserDto userDto =  userDao.findByLogin((String) request.getSession().getAttribute(AuthFilter.AUTH_ATTR_LOGIN));
        ItemDto itemDto = itemDao.findById(addingBet.getItemId());
        if (Objects.nonNull(userDto) && Objects.nonNull(itemDto) && userDto.getOkv().doubleValue() >=  addingBet.getSum().doubleValue()) {
            //System.out.println(addingBet.getItemId() + " " + addingBet.getEvent() + " " + addingBet.getKoef() + " " + addingBet.getSum());
            BetDto betDto = new BetDto();
            betDto.setItemDto(itemDto);
            betDto.setUserDto(userDto);
            betDto.setBetDate(LocalDate.now());
            betDto.setEvent(Event.valueOf(addingBet.getEvent()));
            betDto.setKoef(addingBet.getKoef());
            betDto.setBetSum(addingBet.getSum());
            betDto.setBetResultSum(BigDecimal.valueOf(0.0));
            betDto.setFinished(false);
            betDao.create(betDto);
            userDto.setOkv(BigDecimal.valueOf(userDto.getOkv().doubleValue() - addingBet.getSum().doubleValue()));
            userDao.update(userDto);
            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong data!");
    }


    @RequestMapping(value = "/addresult", method = RequestMethod.GET)
    public String addResult(Model model, HttpServletRequest request) {
        ItemFilter itemFilter =  new ItemFilter();
        itemFilter.setFinished(false);
        //itemFilter.setDateItemTo(LocalDate.now().plusDays(1));
        model.addAttribute("itemDto", itemDao.findByFilter(itemFilter));
        return "/addresult";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addResult(@RequestBody AddingResult addingResult,
                                  HttpServletRequest request) {
        ItemDto itemDto = itemDao.findById(addingResult.getItemId());
        System.out.println(itemDto.getId());
        List<BetDto> betDtoList = betDao.findByItem(itemDto);

        System.out.println(itemDto);
        System.out.println(betDtoList);
        System.out.println(addingResult.getItemId() + " " + addingResult.getHomeScore() + " " + addingResult.getAwayScore());
        if (Objects.nonNull(itemDto)) {
            itemDto.setHomeScore(addingResult.getHomeScore());
            itemDto.setAwayScore(addingResult.getAwayScore());
            itemDto.setFinished(true);
            System.out.println(itemDto.getId());
            itemDao.update(itemDto);

            if (Objects.nonNull(betDtoList)) {
                for (BetDto betDto : betDtoList) {
                    System.out.println("id = " + betDto.getId());
                    betDto.setFinished(true);
                    betDao.update(betDto);
                    if (betDto.getEvent().equals(Event.WIN1) && addingResult.getHomeScore() > addingResult.getAwayScore()) {
                        betDto.setBetResultSum(BigDecimal.valueOf(betDto.getBetSum().doubleValue() * betDto.getKoef().doubleValue()));
                        UserDto userDto = betDto.getUserDto();
                        userDto.setOkv(BigDecimal.valueOf(userDto.getOkv().doubleValue() + (betDto.getBetSum().doubleValue() * betDto.getKoef().doubleValue())));
                        userDao.update(userDto);
                        betDao.update(betDto);
                    }

                    if (betDto.getEvent().equals(Event.WIN2) && addingResult.getHomeScore() < addingResult.getAwayScore()) {
                        betDto.setBetResultSum(BigDecimal.valueOf(betDto.getBetSum().doubleValue() * betDto.getKoef().doubleValue()));
                        UserDto userDto = betDto.getUserDto();
                        userDto.setOkv(BigDecimal.valueOf(userDto.getOkv().doubleValue() + (betDto.getBetSum().doubleValue() * betDto.getKoef().doubleValue())));
                        userDao.update(userDto);
                        betDao.update(betDto);
                    }

                    if (betDto.getEvent().equals(Event.DRAW) && addingResult.getHomeScore() == addingResult.getAwayScore()) {
                        betDto.setBetResultSum(BigDecimal.valueOf(betDto.getBetSum().doubleValue() * betDto.getKoef().doubleValue()));
                        UserDto userDto = betDto.getUserDto();
                        userDto.setOkv(BigDecimal.valueOf(userDto.getOkv().doubleValue() + (betDto.getBetSum().doubleValue() * betDto.getKoef().doubleValue())));
                        userDao.update(userDto);
                        betDao.update(betDto);
                    }
                }
            }

            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong data!");
    }





    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage logOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseMessage.okMessage(null);
    }



}
