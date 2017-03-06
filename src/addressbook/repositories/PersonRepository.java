package addressbook.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import addressbook.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{
    void delete(Person deleted);
    
    List<Person> findAll();
 
    Person findOne(Integer id);
 
    Person save(Person persisted);
}
