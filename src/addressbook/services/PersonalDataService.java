package addressbook.services;

import addressbook.domain.Address;
import addressbook.domain.Person;
import addressbook.domain.Phone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonalDataService {

    public void insertPersonWithoutAddress(Person person);
    public void insertPersonWithAddressWithoutPhone(Person person);
    public void insertPersonWithAddressAndPhone(Person person);
    public void removePersonFromAddress(Address address);
    public void removePhoneFromPerson(Phone phone);
    public List<Person> getAllPeople();
    public List<Person> getPeopleAtAddress(Address address);
    public Person getPersonByPhoneNumber(String phoneNumber);
    public Phone getPhoneNumberAtAddress(Address address);
}
