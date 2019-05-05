package com.apbdoo.lab1;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

    @Test
    public void contructorDI(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextDI.xml");
        Subscription theSubscription = context.getBean("myBooksSubscription", Subscription.class);
        System.out.println(theSubscription.getPrice() + " " + theSubscription.getDescription());
        context.close();
    }

    @Test
    public void setterDI(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextDI.xml");
        Subscription theSubscription = context.getBean("myMoviesSubscription", Subscription.class);
        System.out.println(theSubscription.getPrice() + " " + theSubscription.getDescription());
        context.close();
    }

}
