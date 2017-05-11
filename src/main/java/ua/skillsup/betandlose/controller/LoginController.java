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
import ua.skillsup.betandlose.service.BetService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private BetService betService;
    @Autowired
    private UserDao userDao;



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
        return betService.createNewUser(userDto.getLogin(), userDto.getPassword(), userDto.getEmail(),
                userDto.getFirstName(), userDto.getLastName());
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage auth(@RequestBody Credentials credentials,
                       HttpServletRequest request) {
        return betService.auth(credentials.getLogin(), credentials.getPassword(), request.getSession());
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage logOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseMessage.okMessage(null);
    }



}
