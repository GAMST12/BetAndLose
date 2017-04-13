package ua.skillsup.betandlose.dao.entity;

import ua.skillsup.betandlose.model.enumeration.Sex;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TEAM")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tms_team_id")
    private long id;
    @Column(name = "tms_team", nullable = false, length = 128)
    private String team;
    @Column(name = "tms_city", nullable = false, length = 128)
    private String city;
    @Column(name = "tms_country", nullable = false, length = 128)
    private String country;
    @Column(name = "tms_sex", nullable = false, length = 8)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tms_sp_id")
    private KindSport kindSport;

    @OneToMany(mappedBy = "homeTeam")
    private Set<Item> homeTeams;

    @OneToMany(mappedBy = "awayTeam")
    private Set<Item> awayTeams;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public KindSport getSport() {
        return kindSport;
    }

    public void setSport(KindSport kindSport) {
        this.kindSport = kindSport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team1 = (Team) o;

        if (id != team1.id) return false;
        if (city != null ? !city.equals(team1.city) : team1.city != null) return false;
        if (country != null ? !country.equals(team1.country) : team1.country != null) return false;
        if (sex != null ? !sex.equals(team1.sex) : team1.sex != null) return false;
        if (kindSport != null ? !kindSport.equals(team1.kindSport) : team1.kindSport != null) return false;
        if (team != null ? !team.equals(team1.team) : team1.team != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (team != null ? team.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (kindSport != null ? kindSport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", team='" + team + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", sex='" + sex + '\'' +
                ", kindSport=" + kindSport +
                '}';
    }
}
