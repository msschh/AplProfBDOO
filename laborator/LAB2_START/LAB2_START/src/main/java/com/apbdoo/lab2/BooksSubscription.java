package com.apbdoo.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BooksSubscription implements Subscription{
    DiscountCalculator discountCalculator;

    public BooksSubscription() {
    }

    @Autowired
    public BooksSubscription(@Qualifier("discountCalculatorImpl") DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    public double getPrice() {
        return discountCalculator.calculate(450);
    }

    public String getDescription() {
        return "yearly payment plan";
    }

}
