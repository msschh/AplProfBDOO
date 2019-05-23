package com.apbdoo.lab1;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

    @Test
    public void testLifeCycle(){
        ClassPathXmlApplicationContext context =
                new
                        ClassPathXmlApplicationContext("applicationContextDI.xml");
        SportSubscription theSubscription =
                context.getBean("mySportSubscription", SportSubscription.class);
        System.out.println(theSubscription.getPrice() + " " +
                theSubscription.getDescription());
        SportSubscription theSubscription2 =
                context.getBean("mySportSubscription", SportSubscription.class);
        System.out.println(theSubscription2.getPrice() + " " +
                theSubscription2.getDescription());
        Assert.assertNotEquals(theSubscription, theSubscription2);
        context.close();
    }
}
