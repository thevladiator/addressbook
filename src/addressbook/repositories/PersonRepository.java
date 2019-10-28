package addressbook.repositories;

import addressbook.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{

    void delete(Person deleted);

    List<Person> findAll();
 
    Person save(Person persisted);
}
