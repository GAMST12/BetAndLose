package ua.skillsup.betandlose.model;

import ua.skillsup.betandlose.dao.entity.User;

import java.math.BigDecimal;

public class AccountDto {
    private UserDto user;
    private BigDecimal okv;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
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

        AccountDto that = (AccountDto) o;

        if (okv != null ? !okv.equals(that.okv) : that.okv != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

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
        return "AccountDto{" +
                "user=" + user +
                ", okv=" + okv +
                '}';
    }
}
