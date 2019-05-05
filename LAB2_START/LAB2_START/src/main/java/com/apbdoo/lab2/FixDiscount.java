package com.apbdoo.lab2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FixDiscount implements DiscountCalculator {

    public double calculate(int price) {
        return 0.85 * price;
    }
}
