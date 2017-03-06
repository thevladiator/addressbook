package addressbook;

import addressbook.data.PersonDataGenerator;
import addressbook.services.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan("addressbook.repositories")
public class SpringDriver {
    
    public static void main(String[] args) {
        System.out.println("I'm starting....");
        ApplicationContext context =
            new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
        
        
        PersonService service = context.getBean(PersonService.class);
        service.savePersonWithAddress(PersonDataGenerator.createPersonWithAddress());

        System.out.println("Persons: " + service.getPeople());
    }

}
