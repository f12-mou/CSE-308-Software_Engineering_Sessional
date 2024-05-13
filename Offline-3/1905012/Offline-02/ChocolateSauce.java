package com.company;

public class ChocolateSauce extends Condiment{
    Beverage beverage;
    int cost;

    public ChocolateSauce(Beverage beverage) {
        this.beverage = beverage;
        cost = 60;
    }

    @Override
    public void printDescription() {
        beverage.printDescription();
        System.out.println("Chocolate Sauce               "+"- 60 taka");
    }

    @Override
    public int getCost() {
        return this.cost+ beverage.getCost();
    }
}
