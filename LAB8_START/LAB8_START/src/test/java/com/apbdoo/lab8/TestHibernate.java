package com.apbdoo.lab8;

import com.apbdoo.lab8.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

@Slf4j
public class TestHibernate {

    @Test
    public void testHibernate(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {
            // create customer
            log.info("Creating new customer...");
            Customer tempCustomer= new Customer();
            tempCustomer.setFirstName("first name");
            tempCustomer.setLastName("last name");
            // start a transaction
            session.beginTransaction();
            // save customer object
            log.info("Saving customer...");
            session.save(tempCustomer);

            // commit
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}







