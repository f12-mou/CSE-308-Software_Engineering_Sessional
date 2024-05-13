package com.company;

public class CoffeeBeans extends Condiment {
    Beverage beverage;
    int cost;
    public CoffeeBeans(Beverage beverage) {
        this.beverage = beverage;
        cost = 30;
    }



    @Override
    public void printDescription() {
        beverage.printDescription();
        System.out.println("Extra Grinded coffee beans    "+"- 30 taka");
    }

    @Override
    public int getCost() {
        return beverage.getCost()+ this.cost;
    }
}
