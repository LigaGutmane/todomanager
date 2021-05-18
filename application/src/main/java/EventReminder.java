import java.awt.*;
import java.time.LocalDate;

public class EventReminder {

    User user;
    Event event1;
    LocalDate setTime;
    LocalDate reminderTime;

    public EventReminder(User user, Event event1, LocalDate setTime, LocalDate reminderTime) {
        this.user = user;
        this.event1 = event1;
        this.setTime = setTime;
        this.reminderTime = reminderTime;
    }

    public EventReminder() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent1() {
        return event1;
    }

    public void setEvent1(Event event1) {
        this.event1 = event1;
    }

    public LocalDate getSetTime() {
        return setTime;
    }

    public void setSetTime(LocalDate setTime) {
        this.setTime = setTime;
    }

    public LocalDate getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalDate reminderTime) {
        this.reminderTime = reminderTime;
    }


    @Override
    public String toString() {
        return "EventReminder{" +
                "user=" + user +
                ", event1=" + event1 +
                ", setTime=" + setTime +
                ", reminderTime=" + reminderTime +
                '}';
    }

    public void setTime(LocalDate now) {
    }
}
