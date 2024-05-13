package com.company;

public class DairyCream implements Beverage{
    Beverage beverage;
    int cost;

    public DairyCream(Beverage beverage) {
        this.beverage = beverage;
        cost = 40;
    }

    @Override
    public void printDescription() {
        beverage.printDescription();
        System.out.println("Dairy Cream                   "+"- 40 taka");
    }

    @Override
    public int getCost() {
        return this.cost+ beverage.getCost();
    }
}
