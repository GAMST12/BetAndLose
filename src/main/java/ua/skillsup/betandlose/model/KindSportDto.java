package ua.skillsup.betandlose.model;

public class KindSportDto {

    private long id;
    private String sport;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KindSportDto that = (KindSportDto) o;

        if (id != that.id) return false;
        if (sport != null ? !sport.equals(that.sport) : that.sport != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (sport != null ? sport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "KindSportDto{" +
                "id=" + id +
                ", sport='" + sport + '\'' +
                '}';
    }
}
