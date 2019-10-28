package addressbook;

import java.util.TreeSet;

import addressbook.data.AddressBookDb;
import addressbook.domain.Person;

public class AddressBookDriver {

    public static void main(String[] args) {
        
        //System.out.println(AddressBookDb.db.toString());
        
        TreeSet<Person> people = new TreeSet<>(AddressBookDb.peopleDb);
        System.out.println(people.toString());
        //System.out.println(AddressBookDb.peopleDb);

    }
}
