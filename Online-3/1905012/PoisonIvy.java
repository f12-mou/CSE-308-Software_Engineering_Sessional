package com.company;

public class PoisonIvy implements CondimentBeverage{
    Beverage beverage;

    public PoisonIvy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public void getDescription() {
        beverage.getDescription();
        System.out.println("Item: Poinson Ivy");
    }

    @Override
    public double getCost() {
        return (3.38/10)*25;
    }
}
