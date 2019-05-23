package com.apbdoo.lab1;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LifeCycleTest {
    @Test
    public void testLifeCycle(){


        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        SportSubscription theSubscription = context.getBean("mySportSubscription", SportSubscription.class);
        System.out.println(theSubscription.getPrice() + " " + theSubscription.getDescription());


        SportSubscription theSubscription2 = context.getBean("mySportSubscription", SportSubscription.class);
        System.out.println(theSubscription2.getPrice() + " " + theSubscription2.getDescription());


        assertNotEquals(theSubscription, theSubscription2);
        context.close();

    }

    @Test
    public void testSingletonLifeCycle(){


        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        SportSubscription theSubscription = context.getBean("mySportSubscriptionSingleton", SportSubscription.class);
        System.out.println(theSubscription.getPrice() + " " + theSubscription.getDescription());


        SportSubscription theSubscription2 = context.getBean("mySportSubscriptionSingleton", SportSubscription.class);
        System.out.println(theSubscription2.getPrice() + " " + theSubscription2.getDescription());


        assertEquals(theSubscription, theSubscription2);
        context.close();

    }

}
