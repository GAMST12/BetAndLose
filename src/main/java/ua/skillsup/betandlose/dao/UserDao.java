package ua.skillsup.betandlose.dao;

import ua.skillsup.betandlose.model.UserDto;
import java.util.List;

public interface UserDao {
    List<UserDto> findAll();
    UserDto findById(long id);
    UserDto findByLogin(String login);
    long create(UserDto userDto);
    void update(UserDto userDto);
    void delete(UserDto userDto);
}
