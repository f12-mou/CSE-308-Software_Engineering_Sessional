package com.company;

public class BlackCoffee implements Beverage{

    @Override
    public void printDescription() {
        System.out.println("Grinded coffee beans          "+"- 30 taka");
        System.out.println("Water                         "+"-  0 taka");
    }

    @Override
    public int getCost() {
        return 100+30;
    }
}
