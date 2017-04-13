package ua.skillsup.betandlose.dao;

import ua.skillsup.betandlose.dao.entity.Tournament;
import ua.skillsup.betandlose.model.ItemDto;
import ua.skillsup.betandlose.model.TeamDto;
import ua.skillsup.betandlose.model.TournamentDto;

import java.util.List;

public interface ItemDao {

    List<ItemDto> findAll();
    ItemDto findById(long id);
    List<ItemDto> findByTournament(TournamentDto tournamentDto);
    List<ItemDto> findByHomeTeam(TeamDto homeTeamDto);
    List<ItemDto> findByAwayTeam(TeamDto awayTeamDto);
    long create(ItemDto itemDto);
    void update(ItemDto itemDto);
    void delete(ItemDto itemDto);

}
