package net.achike.calendar.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calendar")
public class Calendar implements Serializable {
    
    private static final long serialVersionUID = 4372139553626470607L;

    @Id
    @Column(name="id")
    private Integer id;
    
    @Column(name="name")
    private String name;
    
    private String user;
    
    // One-to-Many
    private List<CalendarEvent> events;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<CalendarEvent> getEvents() {
        return events;
    }

    public void setEvents(List<CalendarEvent> events) {
        this.events = events;
    }
}
