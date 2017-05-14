package ua.skillsup.betandlose.service;

import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.betandlose.model.message.ResponseMessage;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDate;

public interface BetService {
    /**
     * Create new user
     * @param login unique-name for account
     * @param password password for account
     * @param email user's email
     * @param firstName user-s name
     * @param lastName user-s surname
     *
     */
    ResponseMessage createNewUser(String login, String password, String email, String firstName, String lastName);

    /**
     * Add new bet for user
     * @param login bet owner's login
     * @param itemId item's id for bet
     * @param event selected event from item
     * @param koef coefficient from item for selected event
     * @param sum sum of bet
     *
     */
    ResponseMessage addBet(String login, long itemId, String event, BigDecimal koef, BigDecimal sum);

    /**
     * Add new item
     * @param itemDate date of item
     * @param tournamentId item-tournament's id
     * @param homeTeamId home team's id for item
     * @param awayTeamId away team's id for item
     * @param koefWin1 coefficient for homeTeam win
     * @param koefDraw coefficient for draw
     * @param koefWin2 coefficient for awayTeam win
     *
     */
    ResponseMessage addItem(LocalDate itemDate, long tournamentId, long homeTeamId,
                           long awayTeamId, BigDecimal koefWin1, BigDecimal koefDraw,
                           BigDecimal koefWin2);

    /**
     * Add new kind of sport for items
     * @param kindSport kind of sport
     *
     */
    ResponseMessage addKindSport(String kindSport);


    /**
     * Sign in into account
     * @param login account's login
     * @param password account's password
     * @param session request's session for account
     */
    ResponseMessage auth(String login, String password, HttpSession session);

    /**
     * Add result in item
     * @param itemId account's login
     * @param homeScore homeTeam scored
     * @param awayScore awayTeam scored
     */
    ResponseMessage addResult(long itemId, int homeScore, int awayScore);


    /**
     * Add new team for items
     * @param team team's name
     * @param city team's city
     * @param country team's country
     * @param sex team's sex (Man, Woman (from enum Sex))
     * @param kindSport team's kind of sport
     *
     */
    ResponseMessage addTeam(String team, String city, String country, String sex, String kindSport);

    /**
     * Add new tournament for items
     * @param tournament tournament's name
     * @param kindSport tournament's kind of sport
     *
     */
    ResponseMessage addTournament(String tournament, String kindSport);

    /**
     * Deposit money in account
     * @param login account's login
     * @param sum deposit's sum
     *
     */
    ResponseMessage deposit(String login, BigDecimal sum);

    /**
     * Withdraw money from account
     * @param login account's login
     * @param sum withdraw's sum
     *
     */
    ResponseMessage withdraw(String login, BigDecimal sum);

}
