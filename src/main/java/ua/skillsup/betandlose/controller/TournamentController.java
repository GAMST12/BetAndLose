package ua.skillsup.betandlose.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.skillsup.betandlose.dao.KindSportDao;
import ua.skillsup.betandlose.dao.TournamentDao;
import ua.skillsup.betandlose.model.TournamentDto;
import ua.skillsup.betandlose.model.additional.AddingTournament;
import ua.skillsup.betandlose.model.message.ResponseMessage;
import ua.skillsup.betandlose.service.BetService;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class TournamentController {

    @Autowired
    private KindSportDao kindSportDao;
    @Autowired
    private BetService betService;



    @RequestMapping(value = "/addtournament", method = RequestMethod.GET)
    public String getAddTournament(Model model, HttpServletRequest request) {
        model.addAttribute("kindSportDto", kindSportDao.findAll());
        return "/addtournament";
    }

    @RequestMapping(value = "/tournament", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addTournament(@RequestBody AddingTournament addingTournament) {
        return betService.addTournament(addingTournament.getTournament(), addingTournament.getKindSport());
    }

}
