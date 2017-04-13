package ua.skillsup.betandlose.dao.entity;

import ua.skillsup.betandlose.converter.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table (name= "ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "itm_item_id")
    private long id;
    @Column(name = "itm_dat", nullable = false)
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate itemDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itm_tourn_id")
    private Tournament tournament;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itm_team_id_home")
    private Team homeTeam;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itm_team_id_away")
    private Team awayTeam;

    @Column(name = "itm_koef_w1", nullable = false)
    private BigDecimal win1Koef;

    @Column(name = "itm_koef_x", nullable = false)
    private BigDecimal drawKoef;

    @Column(name = "itm_koef_w2", nullable = false)
    private BigDecimal win2Koef;

    @Column(name = "itm_score_home", nullable = false)
    private int homeScore;

    @Column(name = "itm_score_away", nullable = false)
    private int awayScore;

    @Column(name = "itm_fl_finished", nullable = false, columnDefinition = "boolean default false")
    private boolean finished;

    @OneToMany(mappedBy = "item")
    private Set<Bet> bets;


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

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
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

        Item item = (Item) o;

        if (awayScore != item.awayScore) return false;
        if (finished != item.finished) return false;
        if (homeScore != item.homeScore) return false;
        if (id != item.id) return false;
        if (awayTeam != null ? !awayTeam.equals(item.awayTeam) : item.awayTeam != null) return false;
        if (drawKoef != null ? !drawKoef.equals(item.drawKoef) : item.drawKoef != null) return false;
        if (homeTeam != null ? !homeTeam.equals(item.homeTeam) : item.homeTeam != null) return false;
        if (itemDate != null ? !itemDate.equals(item.itemDate) : item.itemDate != null) return false;
        if (tournament != null ? !tournament.equals(item.tournament) : item.tournament != null) return false;
        if (win1Koef != null ? !win1Koef.equals(item.win1Koef) : item.win1Koef != null) return false;
        if (win2Koef != null ? !win2Koef.equals(item.win2Koef) : item.win2Koef != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (itemDate != null ? itemDate.hashCode() : 0);
        result = 31 * result + (tournament != null ? tournament.hashCode() : 0);
        result = 31 * result + (homeTeam != null ? homeTeam.hashCode() : 0);
        result = 31 * result + (awayTeam != null ? awayTeam.hashCode() : 0);
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
        return "Item{" +
                "id=" + id +
                ", itemDate=" + itemDate +
                ", tournament=" + tournament +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", win1Koef=" + win1Koef +
                ", drawKoef=" + drawKoef +
                ", win2Koef=" + win2Koef +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", finished='" + finished + '\'' +
                '}';
    }
}

