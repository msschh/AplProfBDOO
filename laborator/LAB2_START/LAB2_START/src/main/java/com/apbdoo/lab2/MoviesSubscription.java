package com.apbdoo.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MoviesSubscription implements Subscription{
    DiscountCalculator discountCalculator;

    @Autowired
    @Qualifier("discountCalculatorImpl")
    public void setDiscountCalculator(DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    public double getPrice() {
        return discountCalculator.calculate(100);
    }

    public String getDescription() {
        return "monthly payment plan";
    }
}


