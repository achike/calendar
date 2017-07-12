package net.achike.calendar.service;

import java.time.LocalDate;
import java.util.List;

import net.achike.calendar.domain.Calendar;
import net.achike.calendar.domain.CalendarEvent;

public interface CalendarService {
    
    List<CalendarEvent> getCalendarEvents();
    List<CalendarEvent> getEventsByDate(LocalDate startDate, LocalDate endDate);
    
    List<CalendarEvent> getEventsByUser(String username);
    void deleteCalendarEvent(int calanderEventId);
    
    
    
    Calendar getCalendar(String username);
    Calendar createCalendar(Calendar calendar);
}
