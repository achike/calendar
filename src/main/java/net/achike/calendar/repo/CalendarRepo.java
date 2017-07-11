package net.achike.calendar.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.achike.calendar.domain.Calendar;

@Repository
public interface CalendarRepo extends CrudRepository<Calendar,Integer> {

    Calendar findOneByUsername(String username);
    
}
