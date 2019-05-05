package com.apbdoo.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class SportSubscription implements Subscription{
    @Autowired
    DiscountCalculator discountCalculator;

    @PostConstruct
    void initSportSubscription(){
        System.out.println(">>> init sport subscription");
    }

    @PreDestroy
    void destroySportSubscription(){
        System.out.println(">>> destroy sport subscription");
    }

    public double getPrice() {
        return discountCalculator.calculate(1000);
    }

    public String getDescription() {
        return "go practice";
    }
}
