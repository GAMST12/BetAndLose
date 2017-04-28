package ua.skillsup.betandlose.model.filter;

import ua.skillsup.betandlose.model.KindSportDto;
import ua.skillsup.betandlose.model.TournamentDto;

import java.time.LocalDate;

public class ItemFilter {
    private LocalDate dateItemFrom = LocalDate.of(1900,1,1);
    private LocalDate dateItemTo = LocalDate.of(2999,1,1);
    private TournamentDto tournamentDto;
    private KindSportDto kindSportDto;
    private boolean finished = false;

    public LocalDate getDateItemFrom() {
        return dateItemFrom;
    }

    public void setDateItemFrom(LocalDate dateItemFrom) {
        this.dateItemFrom = dateItemFrom;
    }

    public LocalDate getDateItemTo() {
        return dateItemTo;
    }

    public void setDateItemTo(LocalDate dateItemTo) {
        this.dateItemTo = dateItemTo;
    }

    public TournamentDto getTournamentDto() {
        return tournamentDto;
    }

    public void setTournamentDto(TournamentDto tournamentDto) {
        this.tournamentDto = tournamentDto;
    }

    public KindSportDto getKindSportDto() {
        return kindSportDto;
    }

    public void setKindSportDto(KindSportDto kindSportDto) {
        this.kindSportDto = kindSportDto;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemFilter that = (ItemFilter) o;

        if (finished != that.finished) return false;
        if (dateItemFrom != null ? !dateItemFrom.equals(that.dateItemFrom) : that.dateItemFrom != null) return false;
        if (dateItemTo != null ? !dateItemTo.equals(that.dateItemTo) : that.dateItemTo != null) return false;
        if (kindSportDto != null ? !kindSportDto.equals(that.kindSportDto) : that.kindSportDto != null) return false;
        if (tournamentDto != null ? !tournamentDto.equals(that.tournamentDto) : that.tournamentDto != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dateItemFrom != null ? dateItemFrom.hashCode() : 0;
        result = 31 * result + (dateItemTo != null ? dateItemTo.hashCode() : 0);
        result = 31 * result + (tournamentDto != null ? tournamentDto.hashCode() : 0);
        result = 31 * result + (kindSportDto != null ? kindSportDto.hashCode() : 0);
        result = 31 * result + (finished ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ItemFilter{" +
                "dateItemFrom=" + dateItemFrom +
                ", dateItemTo=" + dateItemTo +
                ", tournamentDto=" + tournamentDto +
                ", kindSportDto=" + kindSportDto +
                ", finished=" + finished +
                '}';
    }
}
