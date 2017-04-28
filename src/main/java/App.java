import org.h2.jdbc.JdbcSQLException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.skillsup.betandlose.dao.*;
import ua.skillsup.betandlose.dao.entity.KindSport;
import ua.skillsup.betandlose.dao.entity.Tournament;
import ua.skillsup.betandlose.model.*;
import ua.skillsup.betandlose.model.enumeration.Event;
import ua.skillsup.betandlose.model.filter.ItemFilter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("app-context.xml");
        /*
        //User
        UserDao userDao = context.getBean(UserDao.class);

        UserDto userById = userDao.findById(1);
        System.out.println("userById: " + userById);

        UserDto userByLogin = userDao.findByLogin("GAMST");
        System.out.println("userByLogin: " + userByLogin);

        UserDto newUser = new UserDto();
        newUser.setLogin("admin");
        newUser.setFirstName("admin");
        newUser.setLastName("admin");
        newUser.setEmail("");
        newUser.setRole("A");
        newUser.setPassword("123456");
        newUser.setOkv(BigDecimal.valueOf(0.00));
        newUser.setLoginDate(LocalDate.of(2017, 3, 10));
        Long id = userDao.create(newUser);
        System.out.println(id);

        UserDto newUserById = userDao.findById(id);
        System.out.println("newUserById: " + newUserById);


        newUser.setEmail("admin@betandlose.com");
        newUser.setId(id);
        userDao.update(newUser);

        System.out.println("updatedUser: " + userDao.findById(id));

        userDao.delete(newUser);

        List<UserDto> userList = userDao.findAll();
        System.out.println(userList);

   */

/*
        //KindSport
        KindSportDao kindSportDao = context.getBean(KindSportDao.class);

        KindSportDto kindSportById = kindSportDao.findById(1);
        System.out.println("kindSportById: " + kindSportById);

        KindSportDto kindSportBySport = kindSportDao.findBySport("Football");
        System.out.println("kindSportBySport: " + kindSportBySport);

        KindSportDto newKindSportDto = new KindSportDto();
        newKindSportDto.setSport("Basketbal");
        Long newKindSportDtoId = kindSportDao.create(newKindSportDto);

        KindSportDto newKindSportDtoById = kindSportDao.findById(newKindSportDtoId);
        System.out.println("newKindSportDtoById: " + newKindSportDtoById);

        newKindSportDto.setId(newKindSportDtoId);
        newKindSportDto.setSport("Basketball");
        kindSportDao.update(newKindSportDto);

        System.out.println("updatedKindSport: " + kindSportDao.findById(newKindSportDtoId));

        kindSportDao.delete(newKindSportDto);

        List<KindSportDto> kindSportList = kindSportDao.findAll();
        System.out.println(kindSportList);
*/

        /*
        //Tournament
        TournamentDao tournamentDao = context.getBean(TournamentDao.class);
        KindSportDao kindSportDao = context.getBean(KindSportDao.class);

        TournamentDto tournamentById = tournamentDao.findById(1);
        System.out.println("tournamentById: " + tournamentById);

        TournamentDto tournamentByTournament = tournamentDao.findByTournament("Ukrainian Premier League 2016/2017");
        System.out.println("tournamentByTournament: " + tournamentByTournament);

        TournamentDto newTournamentDto = new TournamentDto();
        newTournamentDto.setTournament("England Premier League 2015/2016");
        newTournamentDto.setSportDto(kindSportDao.findBySport("Football"));
        Long newTournamentDtoId = tournamentDao.create(newTournamentDto);

        TournamentDto newTournamentById = tournamentDao.findById(newTournamentDtoId);
        System.out.println("newTournamentById: " + newTournamentById);

        List<TournamentDto> tournamentListBySport = tournamentDao.findByKindSport(kindSportDao.findBySport("Football"));
        System.out.println(tournamentListBySport);

        newTournamentById.setId(newTournamentDtoId);
        newTournamentById.setTournament("England Premier League 2016/2017");
        tournamentDao.update(newTournamentById);

        System.out.println("updatedTournament: " + tournamentDao.findById(newTournamentDtoId));

        tournamentDao.delete(newTournamentById);

        List<TournamentDto> tournamentList = tournamentDao.findAll();
        System.out.println(tournamentList);
        */

        /*
        //Team
        TeamDao teamDao = context.getBean(TeamDao.class);
        KindSportDao kindSportDao = context.getBean(KindSportDao.class);

        TeamDto teamById = teamDao.findById(1);
        System.out.println("teamById: " + teamById);

        TeamDto teamByTeamCityCountrySex = teamDao.findByTeamCityCountrySex("Dnipro", "Dnipro", "Ukraine", "M");
        System.out.println("teamByTeamCityCountrySex: " + teamByTeamCityCountrySex);

        TeamDto newTeamDto = new TeamDto();
        newTeamDto.setTeam("Shakhtar");
        newTeamDto.setCity("Donetsk");
        newTeamDto.setCountry("Country");
        newTeamDto.setSex(Event.MAN);
        newTeamDto.setSportDto(kindSportDao.findBySport("Football"));
        Long newTeamDtoId = teamDao.create(newTeamDto);

        TeamDto newTeamById = teamDao.findById(newTeamDtoId);
        System.out.println("newTeamById: " + newTeamById);

        newTeamById.setId(newTeamDtoId);
        newTeamById.setCountry("Ukraine");
        teamDao.update(newTeamById);

        System.out.println("updatedTeam:" + teamDao.findById(newTeamDtoId));

        List<TeamDto> teamListBySport = teamDao.findByKindSport(kindSportDao.findBySport("Football"));
        System.out.println(teamListBySport);


        teamDao.delete(newTeamById);

        List<TeamDto> teamList = teamDao.findAll();
        System.out.println(teamList);
        */



        //Item
        ItemDao itemDao = context.getBean(ItemDao.class);
        TournamentDao tournamentDao = context.getBean(TournamentDao.class);
        TeamDao teamDao = context.getBean(TeamDao.class);

        ItemDto itemById = itemDao.findById(1);
        System.out.println("itemById: " + itemById);

        ItemDto newItemDto = new ItemDto();
        newItemDto.setItemDate(LocalDate.of(2017, 3, 20));
        newItemDto.setTournamentDto(tournamentDao.findById(1));
        newItemDto.setHomeTeamDto(teamDao.findById(2));
        newItemDto.setAwayTeamDto(teamDao.findById(1));
        newItemDto.setWin1Koef(BigDecimal.valueOf(2.80));
        newItemDto.setDrawKoef(BigDecimal.valueOf(2.80));
        newItemDto.setWin2Koef(BigDecimal.valueOf(2.80));
        newItemDto.setHomeScore(0);
        newItemDto.setAwayScore(0);
        newItemDto.setFinished(true);
        Long newItemDtoId = itemDao.create(newItemDto);

        ItemDto newItemById = itemDao.findById(newItemDtoId);
        System.out.println("newItemById: " + newItemById);

        newItemById.setId(newItemDtoId);
        newItemById.setAwayScore(2);
        newItemById.setFinished(true);
        itemDao.update(newItemById);

        System.out.println("updatedItem:" + itemDao.findById(newItemDtoId));

        List<ItemDto> itemListByTournament = itemDao.findByTournament(tournamentDao.findByTournament("Ukrainian Premier League 2016/2017"));
        System.out.println(itemListByTournament);
        List<ItemDto> itemListByHomeTeam = itemDao.findByHomeTeam(teamDao.findById(1));
        System.out.println(itemListByHomeTeam);
        List<ItemDto> itemListByAwayTeam = itemDao.findByAwayTeam(teamDao.findById(2));
        System.out.println(itemListByAwayTeam);

        itemDao.delete(newItemById);

        List<ItemDto> itemList = itemDao.findAll();
        System.out.println(itemList);

        List<ItemDto> itemListFilter = itemDao.findByFilter(new ItemFilter());
        System.out.println(itemListFilter);

/*
        //Bet
        BetDao betDao = context.getBean(BetDao.class);
        ItemDao itemDao = context.getBean(ItemDao.class);
        UserDao userDao = context.getBean(UserDao.class);

        BetDto betById = betDao.findById(1);
        System.out.println("betById: " + betById);

        BetDto newBetDto = new BetDto();
        newBetDto.setItemDto(itemDao.findById(1));
        newBetDto.setUserDto(userDao.findByLogin("GAMST"));
        newBetDto.setBetDate(LocalDate.of(2017, 3, 27));
        newBetDto.setEvent(Event.DRAW);
        newBetDto.setBetSum(BigDecimal.valueOf(200.00));
        newBetDto.setBetResultSum(BigDecimal.valueOf(0.00));
        newBetDto.setFinished(false);
        Long newBetDtoId = betDao.create(newBetDto);

        BetDto newBetById = betDao.findById(newBetDtoId);
        System.out.println("newBetById: " + newBetById);

        newBetById.setId(newBetDtoId);
        newBetById.setBetSum(BigDecimal.valueOf(500.00));
        betDao.update(newBetById);

        System.out.println("updatedBet:" + betDao.findById(newBetDtoId));

        List<BetDto> betListByItem = betDao.findByItem(itemDao.findById(1));
        System.out.println("betListByItem: " + betListByItem);
        List<BetDto> betListByUser = betDao.findByUser(userDao.findByLogin("GAMST"));
        System.out.println("betListByUser: " + betListByUser);

        betDao.delete(newBetById);

        List<BetDto> betList = betDao.findAll();
        System.out.println(betList);
*/

        context.stop();
        }
}
