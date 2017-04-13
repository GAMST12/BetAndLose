package ua.skillsup.betandlose.model;

import ua.skillsup.betandlose.model.enumeration.Event;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BetDto {

    private long id;
    private ItemDto itemDto;
    private UserDto userDto;
    private LocalDate betDate;
    private Event event;
    private BigDecimal betSum;
    private BigDecimal betResultSum;
    private boolean finished;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ItemDto getItemDto() {
        return itemDto;
    }

    public void setItemDto(ItemDto itemDto) {
        this.itemDto = itemDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public LocalDate getBetDate() {
        return betDate;
    }

    public void setBetDate(LocalDate betDate) {
        this.betDate = betDate;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public BigDecimal getBetSum() {
        return betSum;
    }

    public void setBetSum(BigDecimal betSum) {
        this.betSum = betSum;
    }

    public BigDecimal getBetResultSum() {
        return betResultSum;
    }

    public void setBetResultSum(BigDecimal betResultSum) {
        this.betResultSum = betResultSum;
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

        BetDto betDto = (BetDto) o;

        if (finished != betDto.finished) return false;
        if (id != betDto.id) return false;
        if (betDate != null ? !betDate.equals(betDto.betDate) : betDto.betDate != null) return false;
        if (betResultSum != null ? !betResultSum.equals(betDto.betResultSum) : betDto.betResultSum != null)
            return false;
        if (betSum != null ? !betSum.equals(betDto.betSum) : betDto.betSum != null) return false;
        if (event != betDto.event) return false;
        if (itemDto != null ? !itemDto.equals(betDto.itemDto) : betDto.itemDto != null) return false;
        if (userDto != null ? !userDto.equals(betDto.userDto) : betDto.userDto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (itemDto != null ? itemDto.hashCode() : 0);
        result = 31 * result + (userDto != null ? userDto.hashCode() : 0);
        result = 31 * result + (betDate != null ? betDate.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (betSum != null ? betSum.hashCode() : 0);
        result = 31 * result + (betResultSum != null ? betResultSum.hashCode() : 0);
        result = 31 * result + (finished ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BetDto{" +
                "id=" + id +
                ", itemDto=" + itemDto +
                ", userDto=" + userDto +
                ", betDate=" + betDate +
                ", event='" + event + '\'' +
                ", betSum=" + betSum +
                ", betResultSum=" + betResultSum +
                ", finished='" + finished + '\'' +
                '}';
    }
}
