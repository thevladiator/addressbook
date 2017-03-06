package addressbook.services;

import addressbook.domain.Person;
import addressbook.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vlad.georgescu on 3/5/2017.
 */
@Service
public class PersonService{

    @Autowired
    private PersonRepository personRepository;

    public void savePersonWithAddress(Person person){
        System.out.println("SAVING: " + person);
        personRepository.save(person);
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
    }
}
