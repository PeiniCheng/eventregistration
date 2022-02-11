package mcgill.ecse321.eventregistration.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mcgill.ecse321.eventregistration.model.Event;
import mcgill.ecse321.eventregistration.model.Person;
import mcgill.ecse321.eventregistration.model.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {

    List<Registration> findByPerson(Person personName);

    boolean existsByPersonAndEvent(Person person, Event eventName);

    Registration findByPersonAndEvent(Person person, Event eventName);

}
