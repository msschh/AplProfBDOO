package com.apbdoo.lab2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDITest {

    @Test
    public void setterDITest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Subscription theSubscription = context.getBean("moviesSubscription", Subscription.class);
        System.out.println(theSubscription.getPrice() + " " + theSubscription.getDescription());
        context.close();
    }
}
