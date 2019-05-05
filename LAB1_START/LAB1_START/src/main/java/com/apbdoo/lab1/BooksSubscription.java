package com.apbdoo.lab1;

public class BooksSubscription implements Subscription{
    DiscountCalculator discountCalculator;

    public BooksSubscription() {}

    public BooksSubscription(DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    public double getPrice() {
        return discountCalculator.calculate(100);
    }

    public String getDescription() {
        return "yearly payment plan";
    }

}
