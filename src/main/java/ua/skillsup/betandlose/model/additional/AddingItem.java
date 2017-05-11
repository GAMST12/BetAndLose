package ua.skillsup.betandlose.model.additional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddingItem {

    private LocalDate date;
    private long tournamentId;
    private long homeTeamId;
    private long awayTeamId;
    private BigDecimal koefWin1;
    private BigDecimal koefDraw;
    private BigDecimal koefWin2;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String stringDate) {
        this.date = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public long getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(long homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public long getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(long awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public BigDecimal getKoefWin1() {
        return koefWin1;
    }

    public void setKoefWin1(BigDecimal koefWin1) {
        this.koefWin1 = koefWin1;
    }

    public BigDecimal getKoefDraw() {
        return koefDraw;
    }

    public void setKoefDraw(BigDecimal koefDraw) {
        this.koefDraw = koefDraw;
    }

    public BigDecimal getKoefWin2() {
        return koefWin2;
    }

    public void setKoefWin2(BigDecimal koefWin2) {
        this.koefWin2 = koefWin2;
    }
}
