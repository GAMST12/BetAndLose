package ua.skillsup.betandlose.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.skillsup.betandlose.filter.AuthFilter;
import ua.skillsup.betandlose.model.message.ResponseMessage;
import ua.skillsup.betandlose.service.BetService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Controller
public class MoneyController {
    @Autowired
    private BetService betService;

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage deposit(@RequestBody BigDecimal sum, HttpServletRequest request) {
        System.out.println(sum);
        return betService.deposit((String)request.getSession().getAttribute(AuthFilter.AUTH_ATTR_LOGIN), sum);
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage withdraw(@RequestBody BigDecimal sum, HttpServletRequest request) {
        System.out.println(sum);
        return betService.withdraw((String)request.getSession().getAttribute(AuthFilter.AUTH_ATTR_LOGIN), sum);
    }


}
