package net.achike.calendar.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="calendar")
public class Calendar implements Serializable {
    
    private static final long serialVersionUID = 4372139553626470607L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Column(name="calendar_name")
    private String calendarName;
    
    @Column(name="username")
    private String username;
    
    @Column(name="external_id")
    private String externalId;
    
    @OneToMany
    private List<CalendarEvent> events;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CalendarEvent> getEvents() {
        return events;
    }

    public void setEvents(List<CalendarEvent> events) {
        this.events = events;
    }
}
