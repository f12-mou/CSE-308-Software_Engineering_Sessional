package com.company;

public class MilkCoffee implements Beverage{

    @Override
    public void printDescription() {
        System.out.println("Grinded coffee beans          "+"- 30 taka");
        System.out.println("Milk                          "+"- 50 taka");
    }

    @Override
    public int getCost() {
        return 100+80;
    }
}
