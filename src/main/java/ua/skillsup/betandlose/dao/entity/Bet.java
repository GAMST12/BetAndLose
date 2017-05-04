package ua.skillsup.betandlose.dao.entity;


import ua.skillsup.betandlose.converter.LocalDatePersistenceConverter;
import ua.skillsup.betandlose.model.enumeration.Event;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="BET")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bts_bet_id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bts_item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bts_user_id")
    private User user;

    @Column(name = "bts_bet_dat", nullable = false)
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate betDate;

    @Column(name = "bts_event", nullable = false, length = 8)
    @Enumerated(EnumType.STRING)
    private Event event;

    @Column(name = "bts_koef", nullable = false)
    private BigDecimal koef;

    @Column(name = "bts_sum", nullable = false)
    private BigDecimal betSum;

    @Column(name = "bts_total", nullable = false)
    private BigDecimal betResultSum;

    @Column(name = "bts_fl_finished", nullable = false, columnDefinition = "boolean default false")
    private boolean finished;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getBetDate() {
        return betDate;
    }

    public void setBetDate(LocalDate betDate) {
        this.betDate = betDate;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public BigDecimal getKoef() {
        return koef;
    }

    public void setKoef(BigDecimal koef) {
        this.koef = koef;
    }

    public BigDecimal getBetSum() {
        return betSum;
    }

    public void setBetSum(BigDecimal betSum) {
        this.betSum = betSum;
    }

    public BigDecimal getBetResultSum() {
        return betResultSum;
    }

    public void setBetResultSum(BigDecimal betResultSum) {
        this.betResultSum = betResultSum;
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

        Bet bet = (Bet) o;

        if (finished != bet.finished) return false;
        if (id != bet.id) return false;
        if (betDate != null ? !betDate.equals(bet.betDate) : bet.betDate != null) return false;
        if (betResultSum != null ? !betResultSum.equals(bet.betResultSum) : bet.betResultSum != null) return false;
        if (betSum != null ? !betSum.equals(bet.betSum) : bet.betSum != null) return false;
        if (event != bet.event) return false;
        if (item != null ? !item.equals(bet.item) : bet.item != null) return false;
        if (koef != null ? !koef.equals(bet.koef) : bet.koef != null) return false;
        if (user != null ? !user.equals(bet.user) : bet.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (betDate != null ? betDate.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (koef != null ? koef.hashCode() : 0);
        result = 31 * result + (betSum != null ? betSum.hashCode() : 0);
        result = 31 * result + (betResultSum != null ? betResultSum.hashCode() : 0);
        result = 31 * result + (finished ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", item=" + item +
                ", user=" + user +
                ", betDate=" + betDate +
                ", event=" + event +
                ", koef=" + koef +
                ", betSum=" + betSum +
                ", betResultSum=" + betResultSum +
                ", finished=" + finished +
                '}';
    }
}
