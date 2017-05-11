package ua.skillsup.betandlose.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.skillsup.betandlose.dao.*;
import ua.skillsup.betandlose.model.BetDto;
import ua.skillsup.betandlose.model.ItemDto;
import ua.skillsup.betandlose.model.UserDto;
import ua.skillsup.betandlose.model.additional.AddingResult;
import ua.skillsup.betandlose.model.enumeration.Event;
import ua.skillsup.betandlose.model.filter.ItemFilter;
import ua.skillsup.betandlose.model.message.ResponseMessage;
import ua.skillsup.betandlose.service.BetService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Controller
public class ResultController {

    @Autowired
    private BetService betService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private BetDao betDao;
    @Autowired
    private ItemDao itemDao;


    @RequestMapping(value = "/addresult", method = RequestMethod.GET)
    public String getAddResult(Model model, HttpServletRequest request) {
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
        return betService.addResult(addingResult.getItemId(), addingResult.getHomeScore(), addingResult.getAwayScore());
    }
}
