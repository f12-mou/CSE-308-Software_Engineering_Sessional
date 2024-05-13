package com.company;

public class Cabbage implements CondimentBeverage{
    Beverage beverage;

    public Cabbage(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public void getDescription() {
        beverage.getDescription();
        System.out.println("Item: Cabbage");
    }

    @Override
    public double getCost() {
        return (4.13/10)*25;
    }
}
