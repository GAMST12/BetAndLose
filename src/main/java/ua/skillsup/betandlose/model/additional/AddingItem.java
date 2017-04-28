package ua.skillsup.betandlose.model.additional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddingItem {
    private LocalDate date;
    private String tournament;
    private String homeTeam;
    private String awayTeam;
    private BigDecimal koefWin1;
    private BigDecimal koefDraw;
    private BigDecimal koefWin2;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String stringDate) {
        this.date = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
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
