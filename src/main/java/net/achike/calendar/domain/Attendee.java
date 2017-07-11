package net.achike.calendar.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attendee")
public class Attendee implements Serializable {

    private static final long serialVersionUID = -3604663630157550397L;

    @Id
    @Column(name="id")
    private Integer id;
    
    @Column(name="calendar_event_id")
    private Integer calendarEventId;
    
    @Column(name="name")
    private String name;

    public Integer getCalendarEventId() {
        return calendarEventId;
    }

    public void setCalendarEventId(Integer calendarEventId) {
        this.calendarEventId = calendarEventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
