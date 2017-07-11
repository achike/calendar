package net.achike.calendar.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.achike.calendar.domain.CalendarEvent;
import net.achike.calendar.repo.CalendarEventRepo;
import net.achike.calendar.repo.CalendarRepo;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarEventRepo calendarEventRepo;
    
    @Autowired
    private CalendarRepo calendarRepo;
    
    @Override
    public List<CalendarEvent> getCalendarEvents() {
        
        LocalDate start = LocalDate.now();
        
        LocalDate end = start.plusWeeks(2);
        
        return calendarEventRepo.findByEventDateBetween(start, end);
    }

    @Override
    public List<CalendarEvent> getEventsByUser(String username) {

        return calendarRepo.findOneByUsername(username).getEvents();
    }
    
    @Override
    public void deleteCalendarEvent(int calanderEventId) {
        calendarEventRepo.delete(calanderEventId);
    }
    
}
