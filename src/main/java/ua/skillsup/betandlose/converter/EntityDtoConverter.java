package ua.skillsup.betandlose.converter;

import ua.skillsup.betandlose.dao.entity.*;
import ua.skillsup.betandlose.model.*;

public final class EntityDtoConverter {
    private EntityDtoConverter() {
    }

    public static User convert(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setOkv(userDto.getOkv());
        user.setLoginDate(userDto.getLoginDate());
        return user;
    }

    public static UserDto convert(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setRole(user.getRole());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setOkv(user.getOkv());
        userDto.setLoginDate(user.getLoginDate());
        return userDto;
    }


    public static KindSport convert(KindSportDto kindSportDto) {
        if (kindSportDto == null) {
            return null;
        }
        KindSport kindSport = new KindSport();
        kindSport.setId(kindSportDto.getId());
        kindSport.setSport(kindSportDto.getSport());
        return kindSport;
    }

    public static KindSportDto convert(KindSport kindSport) {
        if (kindSport == null) {
            return null;
        }
        KindSportDto kindSportDto = new KindSportDto();
        kindSportDto.setId(kindSport.getId());
        kindSportDto.setSport(kindSport.getSport());
        return kindSportDto;
    }


    public static Tournament convert(TournamentDto tournamentDto) {
        if (tournamentDto == null) {
            return null;
        }
        Tournament tournament = new Tournament();
        tournament.setId(tournamentDto.getId());
        tournament.setTournament(tournamentDto.getTournament());
        tournament.setSport(convert(tournamentDto.getSportDto()));
        return tournament;
    }

    public static TournamentDto convert(Tournament tournament) {
        if (tournament == null) {
            return null;
        }
        TournamentDto tournamentDto = new TournamentDto();
        tournamentDto.setId(tournament.getId());
        tournamentDto.setTournament(tournament.getTournament());
        tournamentDto.setSportDto(convert(tournament.getSport()));
        return tournamentDto;
    }

    public static Team convert(TeamDto teamDto) {
        if (teamDto == null) {
            return null;
        }
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setTeam(teamDto.getTeam());
        team.setCity(teamDto.getCity());
        team.setCountry(teamDto.getCountry());
        team.setSex(teamDto.getSex());
        team.setSport(convert(teamDto.getSportDto()));
        return team;
    }

    public static TeamDto convert(Team team) {
        if (team == null) {
            return null;
        }
        TeamDto teamDto = new TeamDto();
        teamDto.setId(team.getId());
        teamDto.setTeam(team.getTeam());
        teamDto.setCity(team.getCity());
        teamDto.setCountry(team.getCountry());
        teamDto.setSex(team.getSex());
        teamDto.setSportDto(convert(team.getSport()));
        return teamDto;
    }


    public static Item convert(ItemDto itemDto) {
        if (itemDto == null) {
            return null;
        }
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setItemDate(itemDto.getItemDate());
        item.setTournament(convert(itemDto.getTournamentDto()));
        item.setHomeTeam(convert(itemDto.getHomeTeamDto()));
        item.setAwayTeam(convert(itemDto.getAwayTeamDto()));
        item.setWin1Koef(itemDto.getWin1Koef());
        item.setDrawKoef(itemDto.getDrawKoef());
        item.setWin2Koef(itemDto.getWin2Koef());
        item.setHomeScore(itemDto.getHomeScore());
        item.setAwayScore(itemDto.getAwayScore());
        item.setFinished(itemDto.isFinished());
        return item;
    }

    public static ItemDto convert(Item item) {
        if (item == null) {
            return null;
        }
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setItemDate(item.getItemDate());
        itemDto.setTournamentDto(convert(item.getTournament()));
        itemDto.setHomeTeamDto(convert(item.getHomeTeam()));
        itemDto.setAwayTeamDto(convert(item.getAwayTeam()));
        itemDto.setWin1Koef(item.getWin1Koef());
        itemDto.setDrawKoef(item.getDrawKoef());
        itemDto.setWin2Koef(item.getWin2Koef());
        itemDto.setHomeScore(item.getHomeScore());
        itemDto.setAwayScore(item.getAwayScore());
        itemDto.setFinished(item.isFinished());

        return itemDto;
    }


    public static Bet convert(BetDto betDto) {
        if (betDto == null) {
            return null;
        }
        Bet bet = new Bet();
        bet.setId(betDto.getId());
        bet.setItem(convert(betDto.getItemDto()));
        bet.setUser(convert(betDto.getUserDto()));
        bet.setBetDate(betDto.getBetDate());
        bet.setEvent(betDto.getEvent());
        bet.setBetSum(betDto.getBetSum());
        bet.setBetResultSum(betDto.getBetResultSum());
        bet.setFinished(betDto.isFinished());
        return bet;
    }

    public static BetDto convert(Bet bet) {
        if (bet == null) {
            return null;
        }
        BetDto betDto = new BetDto();
        betDto.setId(betDto.getId());
        betDto.setItemDto(convert(bet.getItem()));
        betDto.setUserDto(convert(bet.getUser()));
        betDto.setBetDate(bet.getBetDate());
        betDto.setEvent(bet.getEvent());
        betDto.setBetSum(bet.getBetSum());
        betDto.setBetResultSum(bet.getBetResultSum());
        betDto.setFinished(bet.isFinished());

        return betDto;
    }



}
