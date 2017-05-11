package ua.skillsup.betandlose.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.skillsup.betandlose.dao.*;
import ua.skillsup.betandlose.filter.AuthFilter;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BetDao betDao;



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

}
