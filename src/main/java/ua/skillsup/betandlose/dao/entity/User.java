package ua.skillsup.betandlose.dao.entity;

import ua.skillsup.betandlose.converter.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usr_user_id")
    private long id;
    @Column(name = "usr_login", nullable = false, length = 50)
    private String login;
    @Column(name = "usr_first_name", nullable = false, length = 128)
    private String firstName;
    @Column(name = "usr_last_name", nullable = false, length = 128)
    private String lastName;
    @Column(name = "usr_role", nullable = false, length = 1)
    private String role;
    @Column(name = "usr_email", nullable = false, length = 256)
    private String email;
    @Column(name = "usr_password", nullable = false, length = 256)
    private String password;
    @Column(name = "usr_okv", nullable = false)
    private BigDecimal okv;
    @Column(name = "usr_login_dte", nullable = false)
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate loginDate;

    @OneToMany(mappedBy = "user")
    private Set<Bet> bets;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getOkv() {
        return okv;
    }

    public void setOkv(BigDecimal okv) {
        this.okv = okv;
    }

    public LocalDate getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(LocalDate loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (loginDate != null ? !loginDate.equals(user.loginDate) : user.loginDate != null) return false;
        if (okv != null ? !okv.equals(user.okv) : user.okv != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (okv != null ? okv.hashCode() : 0);
        result = 31 * result + (loginDate != null ? loginDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", okv=" + okv +
                ", loginDate=" + loginDate +
                '}';
    }
}
