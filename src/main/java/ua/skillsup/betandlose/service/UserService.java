package ua.skillsup.betandlose.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.skillsup.betandlose.dao.UserDao;
import ua.skillsup.betandlose.model.UserDto;

import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserDto getUserInformation (String login) {
        UserDto userDto = userDao.findByLogin(login);
        return userDto;
    }
}
