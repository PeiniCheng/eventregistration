package mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import mcgill.ecse321.eventregistration.model.Person;

public interface PersonRepository extends CrudRepository<Person, String>{

    Person findPersonByName(String name);

}
