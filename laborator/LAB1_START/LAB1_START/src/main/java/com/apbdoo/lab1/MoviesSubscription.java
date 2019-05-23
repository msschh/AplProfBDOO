package com.apbdoo.lab1;

public class MoviesSubscription implements Subscription{
    DiscountCalculatorImpl discountCalculatorImpl;

    public void setDiscountCalculatorImpl(DiscountCalculatorImpl discountCalculatorImpl) {
        this.discountCalculatorImpl = discountCalculatorImpl;
    }

    public double getPrice() {
        return discountCalculatorImpl.calculate(10);
    }

    public String getDescription() {
        return "monthly payment plan";
    }
}


