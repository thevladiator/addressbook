package addressbook.data;

import java.util.ArrayList;
import java.util.List;

import addressbook.domain.Phone;
import addressbook.domain.PhoneType;
import org.springframework.stereotype.Component;

import addressbook.domain.Address;
import addressbook.domain.Person;

@Component
public class PersonDataGenerator {
    
    public static List<Address> createAddresses(){
        List<Address> addresses = new ArrayList<Address>();
        Address address = new Address();
        address.setCity("Camarillo");
        address.setCountry("USA");
        address.setCounty("Ventura");
        address.setStreetAddress("123 street");
        
        Address address1 = new Address();
        address1.setCity("Thoudand Oaks");
        address1.setCountry("USA");
        address1.setCounty("Ventura");
        address1.setStreetAddress("111 new street");
        
        addresses.add(address);
        addresses.add(address1);
        
        return addresses;
    }
    
    public static List<Person> createPeople() {
        List<Person> people = new ArrayList<Person>();
        
        Person person = new Person();
        person.setFirstName("Beni");
        person.setLastName("Georgescu");
        Person person1 = new Person();
        person1.setFirstName("Cristina");
        person1.setLastName("Georgescu");
        
        people.add(person);
        people.add(person1);
        
        return people;
    }
    
    public static Person createPersonWithAddress() {
        Person person = createPeople().get(0);
        person.setAddresses(createAddresses());
        
        return person;
    }

    public static Person createPersonWithAddressAndPhone(){
        Person person = createPersonWithAddress();
        person.setPhones(createPhoneNumbers());
        return person;
    }

    public static List<Phone> createPhoneNumbers(){
        List<Phone> phones = new ArrayList<>();

        Phone phone = new Phone();
        phone.setNumber("123-456-7890");
        phone.setType(PhoneType.FIXED);

        Phone phone1 = new Phone();
        phone1.setNumber("111-222-3333");
        phone1.setType((PhoneType.CELL));

        phones.add(phone);
        phones.add(phone1);

        return phones;
    }

}
