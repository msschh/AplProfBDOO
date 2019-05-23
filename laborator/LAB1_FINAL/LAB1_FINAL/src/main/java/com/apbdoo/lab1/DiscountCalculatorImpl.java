package com.apbdoo.lab1;

public class DiscountCalculatorImpl implements DiscountCalculator {
    private double percent;

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double calculate(int price){

        return (1 - percent)*price;
    }
}
