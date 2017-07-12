package net.achike.calendar.service;

import java.util.List;

import net.achike.calendar.domain.Calendar;
import net.achike.calendar.domain.CalendarEvent;

public interface CalendarService {
    
    List<CalendarEvent> getCalendarEvents();
    
    List<CalendarEvent> getEventsByUser(String username);

    void deleteCalendarEvent(int calanderEventId);
    
    Calendar createCalendar(Calendar calendar);
    
}
