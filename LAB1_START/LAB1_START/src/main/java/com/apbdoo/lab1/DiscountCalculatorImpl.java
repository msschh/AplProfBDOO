package com.apbdoo.lab1;

public class DiscountCalculatorImpl implements DiscountCalculator {
    Double percent;

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public double calculate (int price) {
        return percent * price;
    }
}
