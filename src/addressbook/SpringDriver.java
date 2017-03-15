package addressbook;

import addressbook.data.PersonDataGenerator;
import addressbook.services.PersonalDataServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDriver {
    
    public static void main(String[] args) {
        System.out.println("I'm starting....");
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"/resources/applicationContext.xml"});

        //RegistrationClass registrationClass = context.getBean(RegistrationClass.class);
        PersonalDataServiceImpl personService = context.getBean(PersonalDataServiceImpl.class);

        personService.insertPersonWithAddressAndPhone(PersonDataGenerator.createPersonWithAddressAndPhone());

        System.out.println(personService.getAllPeople());

        //registrationClass.insertData();
        //registrationClass.displayExistingData();

    }
}
