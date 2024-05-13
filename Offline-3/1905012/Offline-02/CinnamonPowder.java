package com.company;

public class CinnamonPowder extends Condiment {
    Beverage beverage;
    int cost;

    public CinnamonPowder(Beverage beverage) {
        this.beverage = beverage;
        cost = 50;
    }

    @Override
    public void printDescription() {
        beverage.printDescription();
        System.out.println("Cinnamon Powder               "+"- 50 taka");
    }

    @Override
    public int getCost() {
        return this.cost+beverage.getCost();
    }
}
