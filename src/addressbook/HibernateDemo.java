package addressbook;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import addressbook.domain.Person;
import org.hibernate.Transaction;

import java.io.Serializable;

public class HibernateDemo {
    public static void main(String[] args) {
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;
         
        Person student = new Person();
        student.setFirstName("Vlad");
        student.setLastName("Georgescu");

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            System.out.println("Inserted student: " + student.toString() + " id: " + student.getId());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println ("Rolled Back");
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        HibernateUtil.shutdown();
    }

}
