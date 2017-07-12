package net.achike.calendar.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.achike.calendar.domain.Calendar;
import net.achike.calendar.domain.CalendarEvent;
import net.achike.calendar.service.CalendarService;

/**
 * Implement APIs to allow a user to retrieve the list of events for a day, a
 * week, or a month.
 * 
 * @author achike
 *
 */

@CrossOrigin(origins={"http://localhost:4200","http://calendar.achike.net"})
@RestController
public class CalendarController {
    
    @Autowired
    private CalendarService calendarService;
    
    @GetMapping(path="/events", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<CalendarEvent> getEventsByDateQuery(@RequestParam(value="start",required=false) String startDate ) {
        
        if(null == startDate) {
            return calendarService.getCalendarEvents();
        }
        
        return calendarService.getEventsByDate(LocalDate.parse(startDate), LocalDate.parse(startDate));
    }
    
    @GetMapping("/{username}/events")
    public List<CalendarEvent> getEventsByUser(@PathVariable String username) {
        return calendarService.getEventsByUser(username);
    }
    
    @PostMapping(path="/{username}/events", consumes=MediaType.APPLICATION_JSON_VALUE)
    public void createCalendarEvent(@PathVariable String username, @RequestBody CalendarEvent calendarEvent) {

        // TODO Confirm that the current user can view this calendar.
    }
    
    @PutMapping("/{username}/events/{calanderEventId}")
    public List<CalendarEvent> updateCalendarEvent(@PathVariable String username, @PathVariable int calanderEventId) {
        return calendarService.getCalendarEvents();
    }
    
    @DeleteMapping("/{username}/events/{calanderEventId}")
    public void deleteCalendarEvent(@PathVariable String username, @PathVariable int calanderEventId) {
        calendarService.deleteCalendarEvent(calanderEventId);
    }
    
    
    @PostMapping(path="/calendar", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public void createCalendar(@RequestBody Calendar calendar) {

        calendarService.createCalendar(calendar);
    }
    
    @GetMapping(path="/{username}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Calendar getCalendar(@PathVariable String username) {
        return calendarService.getCalendar(username);
    }
    
}
