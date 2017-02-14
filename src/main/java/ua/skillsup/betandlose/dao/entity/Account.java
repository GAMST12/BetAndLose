package ua.skillsup.betandlose.dao.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

public class Account {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "acc_user_id", referencedColumnName = "usr_user_id")
    private User user;
    @Column(name = "acc_okv", nullable = false)
    private BigDecimal okv;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getOkv() {
        return okv;
    }

    public void setOkv(BigDecimal okv) {
        this.okv = okv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (okv != null ? !okv.equals(account.okv) : account.okv != null) return false;
        if (user != null ? !user.equals(account.user) : account.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (okv != null ? okv.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "user=" + user +
                ", okv=" + okv +
                '}';
    }
}
