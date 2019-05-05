package com.apbdoo.lab2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DiscountCalculatorImpl implements DiscountCalculator {
    @Value("${discount.percent}")
    private double percent;

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double calculate(int price){

        return (1 - percent)*price;
    }
}
