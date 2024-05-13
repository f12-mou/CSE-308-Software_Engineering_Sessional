package com.company;

public class DragonKidney implements CondimentBeverage{
    Beverage beverage;

    public DragonKidney(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public void getDescription() {
        beverage.getDescription();
        System.out.println("Item: Dragon Kidney");
    }

    @Override
    public double getCost() {

        return (5.86/10)*25;
    }
}
