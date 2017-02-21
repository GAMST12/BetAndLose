package ua.skillsup.betandlose.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @Column(name = "acc_user_id", nullable = false)
    private long id;
    @Column(name = "acc_okv", nullable = false)
    private BigDecimal okv;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acc_user_id")
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getOkv() {
        return okv;
    }

    public void setOkv(BigDecimal okv) {
        this.okv = okv;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (okv != null ? !okv.equals(account.okv) : account.okv != null) return false;
        if (user != null ? !user.equals(account.user) : account.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (okv != null ? okv.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", okv=" + okv +
                ", user=" + user +
                '}';
    }
}
