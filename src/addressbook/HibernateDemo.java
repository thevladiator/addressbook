package addressbook;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import addressbook.domain.Person;

public class HibernateDemo {
    public static void main(String[] args) {
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
         
        Person student = new Person();
        student.setFirstName("Vlad");
        student.setLastName("Georgescu");
         
        session.save(student);
        session.getTransaction().commit();
         
        session.close();
 
    }

}
