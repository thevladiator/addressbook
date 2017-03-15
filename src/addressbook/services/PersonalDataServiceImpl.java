package addressbook.services;

import addressbook.data.PersonDataGenerator;
import addressbook.domain.Address;
import addressbook.domain.Person;
import addressbook.domain.Phone;
import addressbook.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class PersonalDataServiceImpl implements PersonalDataService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void insertPersonWithoutAddress(Person person) {
        personRepository.save(PersonDataGenerator.createPeople());
    }

    @Override
    public void insertPersonWithAddressWithoutPhone(Person person) {
        personRepository.save(PersonDataGenerator.createPersonWithAddress());
    }

    @Override
    public void insertPersonWithAddressAndPhone(Person person) {
        personRepository.save(PersonDataGenerator.createPersonWithAddressAndPhone());
    }

    @Override
    public void removePersonFromAddress(Address address) {
//        for (Person persistedPerson : personRepository.findAll()) {
//            if (Objects.equals(persistedPerson.add, person)) {
//
//            }
//
//        }

    }

    @Override
    public void removePhoneFromPerson(Phone phone) {

    }

    @Override
    public List<Person> getAllPeople() {
        return null;
    }

    @Override
    public List<Person> getPeopleAtAddress(Address address) {
        return null;
    }

    @Override
    public Person getPersonByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public Phone getPhoneNumberAtAddress(Address address) {
        return null;
    }
}
