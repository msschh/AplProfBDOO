package com.apbdoo.lab1;

public class SportSubscription implements Subscription{

    void initSportSubscription(){
        System.out.println(">>> init sport subscription");
    }

    void destroySportSubscription(){
        System.out.println(">>> destroy sport subscription");
    }

    public double getPrice() {
        return 100;
        //return discountCalculator.calculate(100);
    }

    public String getDescription() {
        return "go practice";
    }
}
