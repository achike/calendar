package net.achike.calendar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.achike.calendar.domain.Calendar;
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
        
        List<CalendarEvent> list = new ArrayList<>();

        for(CalendarEvent event : calendarEventRepo.findAll()) {
            list.add(event);
        }
        
        return list;
    }

    @Override
    public List<CalendarEvent> getEventsByDate(LocalDate startDate, LocalDate endDate) {
        
        return calendarEventRepo.findByEventDateBetween(startDate, endDate);
    }
    
    @Override
    public List<CalendarEvent> getEventsByUser(String username) {

        return calendarRepo.findOneByUsername(username).getEvents();
    }
    
    @Override
    public void deleteCalendarEvent(int calanderEventId) {
        calendarEventRepo.delete(calanderEventId);
    }
    
    @Override
    public Calendar createCalendar(Calendar calendar) {
        return calendarRepo.save(calendar);
    }
    
    @Override
    public Calendar getCalendar(String username) {
        return calendarRepo.findOneByUsername(username);
    }
    
}
