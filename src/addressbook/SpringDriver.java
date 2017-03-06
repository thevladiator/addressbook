package addressbook;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDriver {
    
    public static void main(String[] args) {
        System.out.println("I'm starting....");
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

        RegistrationClass registrationClass = context.getBean(RegistrationClass.class);

        registrationClass.process();

    }
}
