package addressbook.data;

import java.util.ArrayList;
import java.util.List;

import addressbook.domain.Address;
import addressbook.domain.Person;
import addressbook.domain.Phone;
import addressbook.domain.PhoneType;

public class AddressBookDb {
    
    private static int ADDRESS_SEED = 40;
    private static int PHONES_SEED = 40;
    private static int PEOPLE_SEED = 30;
    
    public static final AddressBookDb db = new AddressBookDb();
    
    public static List<Address> addressDb;
    public static List<Person> peopleDb;
    public static List<Phone> phonesDb;
    
    private AddressBookDb (){
        addressDb = createAddresses(ADDRESS_SEED);
        phonesDb = createPhones(PHONES_SEED);
        peopleDb = createPeople(PEOPLE_SEED);
        //Collections.sort(peopleDb);
    }
    
    private static List<Person> createPeople(int seed){
        List<Person> people = new ArrayList<Person>();
        for (int i = 1; i <= seed; i++){
            Person person = new Person();
            person.setFirstName("firstName_" + i);
            person.setLastName("lastName_" + (i%2 == 0 ? "A" : "B") + i);
            person.addAddress(addressDb.get((ADDRESS_SEED/i) - 1));
            person.addAddress(addressDb.get(ADDRESS_SEED % i));
            person.addPhone(phonesDb.get((PHONES_SEED/i) - 1));
            person.addPhone(phonesDb.get(PHONES_SEED % i));
            people.add(person);
        }
        
        return people;
    }
    
    private static List<Address> createAddresses(int seed) {
        List<Address> addresses = new ArrayList<Address>();
        for (int i = 1; i <= seed; i++) {
            Address address = new Address();
            address.setCity("city_" + i);
            address.setCountry("country_" + i);
            address.setStreetAddress(i + " street_" + i);
            
            addresses.add(address);
        }
        return addresses;
    }
    
    private static List<Phone> createPhones (int seed){
        List<Phone> phones = new ArrayList<Phone>();
        final String PHONE_PREFIX_SMALL = "123-456-777";
        final String PHONE_PREFIX_LARGE = "123-456-77";
        for (int i=1; i <= seed; i++){
            Phone phone = new Phone();
            
            if (i < 10)
                phone.setNumber(PHONE_PREFIX_SMALL + i);
            else
                phone.setNumber(PHONE_PREFIX_LARGE + i);
            
            if (i % 2 == 0)
                phone.setType(PhoneType.CELL);
            else
                phone.setType(PhoneType.FIXED);
            
            phones.add(phone);
        }
        
        return phones;
    }
    
    @Override
    public String toString() {
        return "AddressBook. size:" + peopleDb.size() + "\n" + peopleDb.toString();
    }
}
