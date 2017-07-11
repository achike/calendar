package net.achike.calendar.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.achike.calendar.domain.CalendarEvent;

@Repository
public interface CalendarEventRepo extends CrudRepository<CalendarEvent,Integer> {

    List<CalendarEvent> findByEventDateBetween(LocalDate start, LocalDate end);
    
}
