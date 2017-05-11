package ua.skillsup.betandlose.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.skillsup.betandlose.dao.KindSportDao;
import ua.skillsup.betandlose.model.KindSportDto;
import ua.skillsup.betandlose.model.message.ResponseMessage;
import ua.skillsup.betandlose.service.BetService;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class KindSportController {

    @Autowired
    private BetService betService;

    @RequestMapping(value = "/addkindsport", method = RequestMethod.GET)
    public String getAddKindSport(Model model, HttpServletRequest request) {
        return "/addkindsport";
    }


    @RequestMapping(value = "/kindSport", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addKindSport(@RequestBody KindSportDto kindSportDto) {
        return betService.addKindSport(kindSportDto.getSport());
    }
}
