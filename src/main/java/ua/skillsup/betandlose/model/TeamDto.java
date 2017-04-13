package ua.skillsup.betandlose.model;


import ua.skillsup.betandlose.model.enumeration.Sex;

public class TeamDto {
    private long id;
    private String team;
    private String city;
    private String country;
    private Sex sex;
    private KindSportDto kindSportDto;

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

    public KindSportDto getSportDto() {
        return kindSportDto;
    }

    public void setSportDto(KindSportDto kindSportDto) {
        this.kindSportDto = kindSportDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamDto teamDto = (TeamDto) o;

        if (id != teamDto.id) return false;
        if (city != null ? !city.equals(teamDto.city) : teamDto.city != null) return false;
        if (country != null ? !country.equals(teamDto.country) : teamDto.country != null) return false;
        if (sex != null ? !sex.equals(teamDto.sex) : teamDto.sex != null) return false;
        if (kindSportDto != null ? !kindSportDto.equals(teamDto.kindSportDto) : teamDto.kindSportDto != null) return false;
        if (team != null ? !team.equals(teamDto.team) : teamDto.team != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (team != null ? team.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (kindSportDto != null ? kindSportDto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeamDto{" +
                "id=" + id +
                ", team='" + team + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", sex='" + sex + '\'' +
                ", kindSportDto=" + kindSportDto +
                '}';
    }
}