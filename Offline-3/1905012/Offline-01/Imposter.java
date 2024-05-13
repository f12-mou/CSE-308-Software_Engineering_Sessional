package com.company;

public class Imposter implements BadPassenger{
    @Override
    public void poison() {
        //System.out.println("The Poison Method of Imposter class is called internally.");
        System.out.println("The imposter is poisoning the crewmates.");
        System.out.println();
    }

    @Override
    public void damage() {
        //System.out.println("The Damage Method of Imposter class is called internally.");
        System.out.println("The imposter is damaging the spaceship.");
        System.out.println();
    }
}
