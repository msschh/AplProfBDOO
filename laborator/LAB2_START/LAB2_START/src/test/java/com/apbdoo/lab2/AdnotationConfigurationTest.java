package com.apbdoo.lab2;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AdnotationConfigurationTest {

    @Test
    public void adnotationTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SubscriptionConfig.class);
        ctx.refresh();

        Subscription theSubscription = ctx.getBean("booksSubscription", Subscription.class);
        System.out.println(theSubscription.getPrice() + " " + theSubscription.getDescription());

        ctx.close();
    }
}
