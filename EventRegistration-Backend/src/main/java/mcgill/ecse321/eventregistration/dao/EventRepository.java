package mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import mcgill.ecse321.eventregistration.model.Event;

public interface EventRepository extends CrudRepository<Event, String> {

    Event findEventByName(String name);

}
