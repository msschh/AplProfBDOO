package com.apbdoo.lab2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorDITest {
    @Test
    public void constructorDITest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Subscription theSubscription =
                context.getBean("booksSubscription", Subscription.class);
        System.out.println(theSubscription.getPrice() + " "
                + theSubscription.getDescription());
        context.close();
    }

}
