package ua.skillsup.betandlose.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ItemDto {

    private long id;
    private LocalDate itemDate;
    private TournamentDto tournamentDto;
    private TeamDto homeTeamDto;
    private TeamDto awayTeamDto;
    private BigDecimal win1Koef;
    private BigDecimal drawKoef;
    private BigDecimal win2Koef;
    private int homeScore;
    private int awayScore;
    private boolean finished;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getItemDate() {
        return itemDate;
    }

    public void setItemDate(LocalDate itemDate) {
        this.itemDate = itemDate;
    }

    public TournamentDto getTournamentDto() {
        return tournamentDto;
    }

    public void setTournamentDto(TournamentDto tournamentDto) {
        this.tournamentDto = tournamentDto;
    }

    public TeamDto getHomeTeamDto() {
        return homeTeamDto;
    }

    public void setHomeTeamDto(TeamDto homeTeamDto) {
        this.homeTeamDto = homeTeamDto;
    }

    public TeamDto getAwayTeamDto() {
        return awayTeamDto;
    }

    public void setAwayTeamDto(TeamDto awayTeamDto) {
        this.awayTeamDto = awayTeamDto;
    }

    public BigDecimal getWin1Koef() {
        return win1Koef;
    }

    public void setWin1Koef(BigDecimal win1Koef) {
        this.win1Koef = win1Koef;
    }

    public BigDecimal getDrawKoef() {
        return drawKoef;
    }

    public void setDrawKoef(BigDecimal drawKoef) {
        this.drawKoef = drawKoef;
    }

    public BigDecimal getWin2Koef() {
        return win2Koef;
    }

    public void setWin2Koef(BigDecimal win2Koef) {
        this.win2Koef = win2Koef;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemDto itemDto = (ItemDto) o;

        if (awayScore != itemDto.awayScore) return false;
        if (finished != itemDto.finished) return false;
        if (homeScore != itemDto.homeScore) return false;
        if (id != itemDto.id) return false;
        if (awayTeamDto != null ? !awayTeamDto.equals(itemDto.awayTeamDto) : itemDto.awayTeamDto != null) return false;
        if (drawKoef != null ? !drawKoef.equals(itemDto.drawKoef) : itemDto.drawKoef != null) return false;
        if (homeTeamDto != null ? !homeTeamDto.equals(itemDto.homeTeamDto) : itemDto.homeTeamDto != null) return false;
        if (itemDate != null ? !itemDate.equals(itemDto.itemDate) : itemDto.itemDate != null) return false;
        if (tournamentDto != null ? !tournamentDto.equals(itemDto.tournamentDto) : itemDto.tournamentDto != null)
            return false;
        if (win1Koef != null ? !win1Koef.equals(itemDto.win1Koef) : itemDto.win1Koef != null) return false;
        if (win2Koef != null ? !win2Koef.equals(itemDto.win2Koef) : itemDto.win2Koef != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (itemDate != null ? itemDate.hashCode() : 0);
        result = 31 * result + (tournamentDto != null ? tournamentDto.hashCode() : 0);
        result = 31 * result + (homeTeamDto != null ? homeTeamDto.hashCode() : 0);
        result = 31 * result + (awayTeamDto != null ? awayTeamDto.hashCode() : 0);
        result = 31 * result + (win1Koef != null ? win1Koef.hashCode() : 0);
        result = 31 * result + (drawKoef != null ? drawKoef.hashCode() : 0);
        result = 31 * result + (win2Koef != null ? win2Koef.hashCode() : 0);
        result = 31 * result + homeScore;
        result = 31 * result + awayScore;
        result = 31 * result + (finished ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "id=" + id +
                ", itemDate=" + itemDate +
                ", tournamentDto=" + tournamentDto +
                ", homeTeamDto=" + homeTeamDto +
                ", awayTeamDto=" + awayTeamDto +
                ", win1Koef=" + win1Koef +
                ", drawKoef=" + drawKoef +
                ", win2Koef=" + win2Koef +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", finished='" + finished + '\'' +
                '}';
    }
}
