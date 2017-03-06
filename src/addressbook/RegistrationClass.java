package addressbook;

import addressbook.data.PersonDataGenerator;
import addressbook.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by vlad.georgescu on 3/5/2017.
 */
@Component
public class RegistrationClass {

    @Autowired
    PersonService personService;

    public void process() {
        personService.savePersonWithAddress(PersonDataGenerator.createPersonWithAddress());
        System.out.println("Persons: " + personService.getPeople());
    }
}
