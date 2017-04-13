package ua.skillsup.betandlose.dao;

import ua.skillsup.betandlose.model.BetDto;
import ua.skillsup.betandlose.model.ItemDto;
import ua.skillsup.betandlose.model.UserDto;

import java.util.List;

public interface BetDao {
    List<BetDto> findAll();
    BetDto findById(long id);
    List<BetDto> findByUser(UserDto userDto);
    List<BetDto> findByItem(ItemDto itemDto);
    long create(BetDto betDto);
    void update(BetDto betDto);
    void delete(BetDto betDto);

}
