package ua.skillsup.betandlose.model;


import ua.skillsup.betandlose.dao.entity.KindSport;

public class TournamentDto {
    private long id;
    private String tournament;
    private KindSportDto kindSportDto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
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

        TournamentDto that = (TournamentDto) o;

        if (id != that.id) return false;
        if (kindSportDto != null ? !kindSportDto.equals(that.kindSportDto) : that.kindSportDto != null) return false;
        if (tournament != null ? !tournament.equals(that.tournament) : that.tournament != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tournament != null ? tournament.hashCode() : 0);
        result = 31 * result + (kindSportDto != null ? kindSportDto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TournamentDto{" +
                "id=" + id +
                ", tournament='" + tournament + '\'' +
                ", kindSportDto=" + kindSportDto +
                '}';
    }
}
