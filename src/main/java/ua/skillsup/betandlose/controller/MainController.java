package ua.skillsup.betandlose.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.skillsup.betandlose.dao.*;
import ua.skillsup.betandlose.filter.AuthFilter;
import ua.skillsup.betandlose.model.KindSportDto;
import ua.skillsup.betandlose.model.TeamDto;
import ua.skillsup.betandlose.model.TournamentDto;
import ua.skillsup.betandlose.model.UserDto;
import ua.skillsup.betandlose.model.additional.AddingTeam;
import ua.skillsup.betandlose.model.additional.AddingTournament;
import ua.skillsup.betandlose.model.additional.Credentials;
import ua.skillsup.betandlose.model.enumeration.Sex;
import ua.skillsup.betandlose.model.message.ResponseMessage;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Controller
public class MainController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BetDao betDao;
    @Autowired
    private KindSportDao kindSportDao;
    @Autowired
    private TournamentDao tournamentDao;
    @Autowired
    private TeamDao teamDao;




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
        UserDto checkUser =  userDao.findByLogin(userDto.getLogin());
        if (Objects.isNull(checkUser) &&  userDto.getLogin()!=null
                && userDto.getPassword() != null && userDto.getFirstName() != null
                && userDto.getLastName() != null && userDto.getEmail() != null) {
            userDto.setLoginDate(LocalDate.now());
            userDto.setOkv(BigDecimal.valueOf(0.0));
            userDto.setRole("U");
            userDao.create(userDto);
            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong user data!");
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage auth(@RequestBody Credentials credentials,
                       HttpServletRequest request) {
        UserDto userDto =  userDao.findByLogin(credentials.getLogin());
        if (Objects.nonNull(userDto) &&  userDto.getLogin().equals(credentials.getLogin())
                && userDto.getPassword().equals(credentials.getPassword())) {
            request.getSession()
                    .setAttribute(AuthFilter.AUTH_ATTR_DATE, LocalDateTime.now());
            request.getSession()
                    .setAttribute(AuthFilter.AUTH_ATTR_LOGIN, credentials.getLogin());
            request.getSession()
                    .setAttribute(AuthFilter.AUTH_ATTR_ROLE, userDto.getRole());
            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong credentials!");
    }


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

    @RequestMapping(value = "/addkindsport", method = RequestMethod.GET)
    public String getAddKindSport(Model model, HttpServletRequest request) {
        return "/addkindsport";
    }


    @RequestMapping(value = "/kindSport", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addKindSport(@RequestBody KindSportDto kindSportDto) {
        KindSportDto checkKindSport =  kindSportDao.findBySport(kindSportDto.getSport());
        if (Objects.isNull(checkKindSport) &&  kindSportDto.getSport() != null &&  kindSportDto.getSport() != "") {
            kindSportDao.create(kindSportDto);
            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @RequestMapping(value = "/addtournament", method = RequestMethod.GET)
    public String getAddTournament(Model model, HttpServletRequest request) {
        model.addAttribute("kindSportDto", kindSportDao.findAll());
        return "/addtournament";
    }

    @RequestMapping(value = "/tournament", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addTournament(@RequestBody AddingTournament addingTournament) {
        TournamentDto checkTournament =  tournamentDao.findByTournament(addingTournament.getTournament());
        if (Objects.isNull(checkTournament) &&  addingTournament.getTournament() != null
                && addingTournament.getKindSport() != null && addingTournament.getTournament() != ""
                && addingTournament.getKindSport() != "") {
            TournamentDto tournamentDto = new TournamentDto();
            tournamentDto.setTournament(addingTournament.getTournament());
            tournamentDto.setSportDto(kindSportDao.findBySport(addingTournament.getKindSport()));
            System.out.println(tournamentDto);
            tournamentDao.create(tournamentDto);
            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @RequestMapping(value = "/addteam", method = RequestMethod.GET)
    public String getAddTeam(Model model, HttpServletRequest request) {
        model.addAttribute("kindSportDto", kindSportDao.findAll());
        model.addAttribute("sexList", Sex.getAllSex());
        return "/addteam";
    }


    @RequestMapping(value = "/team", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addTeam(@RequestBody AddingTeam addingTeam) {
        System.out.println(addingTeam.getTeam() + " " + addingTeam.getCity() + " " + addingTeam.getCountry()
                + " " + addingTeam.getSex() + " " + addingTeam.getKindSport());
        TeamDto checkTeam =  teamDao.findByTeamCityCountrySex(addingTeam.getTeam(), addingTeam.getCity(), addingTeam.getCountry(), addingTeam.getSex());
        if (Objects.isNull(checkTeam)
                &&  addingTeam.getTeam() != null && addingTeam.getTeam() != ""
                && addingTeam.getCity() != null && addingTeam.getCity() != ""
                && addingTeam.getCountry() != null && addingTeam.getCountry() != ""
                && addingTeam.getSex() != null && addingTeam.getSex() != "") {
            TeamDto teamDto = new TeamDto();
            teamDto.setTeam(addingTeam.getTeam());
            teamDto.setCity(addingTeam.getCity());
            teamDto.setCountry(addingTeam.getCountry());
            teamDto.setSex(Sex.valueOf(addingTeam.getSex()));
            teamDto.setSportDto(kindSportDao.findBySport(addingTeam.getKindSport()));
            System.out.println(teamDto);
            teamDao.create(teamDto);
            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong data!");
    }

    @RequestMapping(value = "/additem", method = RequestMethod.GET)
    public String getAddItem(Model model, HttpServletRequest request) {
        model.addAttribute("tournamentDto", tournamentDao.findAll());
        model.addAttribute("teamDto", teamDao.findAll());
        return "/additem";
    }


    @RequestMapping(value = "/item", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addItem(@RequestBody AddingTeam addingTeam) {
        System.out.println(addingTeam.getTeam() + " " + addingTeam.getCity() + " " + addingTeam.getCountry()
                + " " + addingTeam.getSex() + " " + addingTeam.getKindSport());
        TeamDto checkTeam =  teamDao.findByTeamCityCountrySex(addingTeam.getTeam(), addingTeam.getCity(), addingTeam.getCountry(), addingTeam.getSex());
        if (Objects.isNull(checkTeam)
                &&  addingTeam.getTeam() != null && addingTeam.getTeam() != ""
                && addingTeam.getCity() != null && addingTeam.getCity() != ""
                && addingTeam.getCountry() != null && addingTeam.getCountry() != ""
                && addingTeam.getSex() != null && addingTeam.getSex() != "") {
            TeamDto teamDto = new TeamDto();
            teamDto.setTeam(addingTeam.getTeam());
            teamDto.setCity(addingTeam.getCity());
            teamDto.setCountry(addingTeam.getCountry());
            teamDto.setSex(Sex.valueOf(addingTeam.getSex()));
            teamDto.setSportDto(kindSportDao.findBySport(addingTeam.getKindSport()));
            System.out.println(teamDto);
            teamDao.create(teamDto);
            return ResponseMessage.okMessage(null);
        }
        return ResponseMessage.errorMessage("Wrong data!");
    }



    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage logOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseMessage.okMessage(null);
    }



}
