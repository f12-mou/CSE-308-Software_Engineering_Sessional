package com.company;

public class BaseBeverage implements Beverage{

    @Override
    public void getDescription() {
        System.out.println("Printing Base Solution's Ingredients:");
        System.out.println("A mixture of white spirit");
        System.out.println("Castor oil");
    }

    @Override
    public double getCost() {

        return ((1.23+2.47)/10)*25;
    }
}
