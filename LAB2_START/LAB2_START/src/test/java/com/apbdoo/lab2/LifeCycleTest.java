package com.apbdoo.lab2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LifeCycleTest {

    @Test
    public void testSingletonLifeCycle(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Subscription theSubscription = context.getBean("sportSubscription", Subscription.class);
        System.out.println(theSubscription.getPrice() + " " + theSubscription.getDescription());

        Subscription theSubscription2 = context.getBean("sportSubscription", Subscription.class);
        System.out.println(theSubscription2.getPrice() + " " + theSubscription2.getDescription());

        assertEquals(theSubscription, theSubscription2);
        context.close();
    }

    @Test
    public void testPrototypeLifeCycle(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Subscription theSubscription = context.getBean("booksSubscription", Subscription.class);
        System.out.println(theSubscription.getPrice() + " " + theSubscription.getDescription());

        Subscription theSubscription2 = context.getBean("booksSubscription", Subscription.class);
        System.out.println(theSubscription2.getPrice() + " " + theSubscription2.getDescription());

        assertNotEquals(theSubscription, theSubscription2);
        context.close();
    }

}
