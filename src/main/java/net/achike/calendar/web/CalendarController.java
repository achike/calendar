package net.achike.calendar.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.achike.calendar.domain.CalendarEvent;

/**
 * Implement APIs to allow a user to retrieve the list of events for a day, a
 * week, or a month.
 * 
 * @author achike
 *
 */

@Controller
@RequestMapping("/event")
public class CalendarController {

    @GetMapping("")
    public List<CalendarEvent> getEvents() {
        return null;
    }
    
}
