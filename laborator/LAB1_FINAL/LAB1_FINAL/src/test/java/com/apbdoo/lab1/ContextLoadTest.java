package com.apbdoo.lab1;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoadTest {

    @Test
    public void testXmlContext(){

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Subscription theSubscription = context.getBean("mySportSubscription", Subscription.class);

        // call methods on the bean
        System.out.println(theSubscription.getPrice() + " " + theSubscription.getDescription());

        // close the context
        context.close();
    }


    @Test
    public void testLoadMySportSubscription(){

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Subscription theSubscription = context.getBean("mySportSubscription", Subscription.class);

        // call methods on the bean
        System.out.println(theSubscription.getPrice() + " " + theSubscription.getDescription());

        // close the context
        context.close();
    }
}
