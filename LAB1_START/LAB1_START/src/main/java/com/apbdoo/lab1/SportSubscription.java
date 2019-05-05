package com.apbdoo.lab1;

public class SportSubscription implements Subscription {
    public double getPrice() { return 123.0; }
    public String getDescription() { return "sports description"; }
    public void initSportSubscription() {
        System.out.println("Creare element sportsubscription");
    }
    public void destroySportSubscription() {
        System.out.println("Stergere element sportsubscription");
    }
}
