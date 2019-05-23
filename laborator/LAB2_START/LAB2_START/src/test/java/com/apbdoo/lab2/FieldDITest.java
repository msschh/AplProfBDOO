package com.apbdoo.lab2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FieldDITest {

    @Test
    public void fieldDITest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Subscription theSubscription =
                context.getBean("sportSubscription", Subscription.class);
        System.out.println(theSubscription.getPrice() + " "
                + theSubscription.getDescription());
        context.close();
    }

}
