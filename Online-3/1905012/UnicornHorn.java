package com.company;

public class UnicornHorn implements CondimentBeverage{

    Beverage beverage;

    public UnicornHorn(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public void getDescription() {
        beverage.getDescription();
        System.out.println("Item: UniCornHorn");

    }

    @Override
    public double getCost() {
        return (6.31/10)*25;
    }
}
