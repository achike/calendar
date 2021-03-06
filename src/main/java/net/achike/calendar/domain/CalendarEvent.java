package net.achike.calendar.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="calendar_event")
public class CalendarEvent implements Serializable {
    
    private static final long serialVersionUID = 844763577321764142L;

    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="location")
    private String location;
    
    @Column(name="event_date")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate eventDate;
    
    @Column(name="event_time")
    @Convert(converter = LocalTimeConverter.class)
    private LocalTime eventTime;
    
    @OneToMany
    @JoinColumn(name="calendar_event_id")
    private List<Attendee> attendees;
    
    @Column(name="reminder_time")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime reminderTime;
    
    @Column(name="reminder_sent")
    private boolean reminderSent;

    @ManyToOne
    @JoinColumn(name="calendar_id")
    @JsonManagedReference
    private Calendar calendar;
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    public LocalDateTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalDateTime reminderTime) {
        this.reminderTime = reminderTime;
    }

    public boolean isReminderSent() {
        return reminderSent;
    }

    public void setReminderSent(boolean reminderSent) {
        this.reminderSent = reminderSent;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
