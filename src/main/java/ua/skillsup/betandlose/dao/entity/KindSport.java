package ua.skillsup.betandlose.dao.entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "KIND_SPORT")
public class KindSport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ksp_sp_id")
    private long id;
    @Column(name = "ksp_sport", nullable = false, length = 128)
    private String sport;

    @OneToMany(mappedBy = "kindSport")
    private Set<Tournament> tournaments;

    @OneToMany(mappedBy = "kindSport")
    private Set<Team> teams;


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

        KindSport kindSport = (KindSport) o;

        if (id != kindSport.id) return false;
        if (sport != null ? !sport.equals(kindSport.sport) : kindSport.sport != null) return false;

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
        return "KindSport{" +
                "id=" + id +
                ", sport='" + sport + '\'' +
                '}';
    }
}
