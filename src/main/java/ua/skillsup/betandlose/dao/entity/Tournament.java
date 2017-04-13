package ua.skillsup.betandlose.dao.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TOURNAMENT")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trn_tourn_id")
    private long id;
    @Column(name = "trn_tournament", nullable = false, length = 256)
    private String tournament;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trn_sp_id")
    private KindSport kindSport;

    @OneToMany(mappedBy = "tournament")
    private Set<Item> items;


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

        Tournament that = (Tournament) o;

        if (id != that.id) return false;
        if (kindSport != null ? !kindSport.equals(that.kindSport) : that.kindSport != null) return false;
        if (tournament != null ? !tournament.equals(that.tournament) : that.tournament != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tournament != null ? tournament.hashCode() : 0);
        result = 31 * result + (kindSport != null ? kindSport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", tournament='" + tournament + '\'' +
                ", kindSport=" + kindSport +
                '}';
    }
}
