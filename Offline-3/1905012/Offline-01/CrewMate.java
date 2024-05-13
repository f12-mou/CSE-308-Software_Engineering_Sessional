package com.company;

public class CrewMate implements GoodPassenger{
    @Override
    public void study() {
        System.out.println("The Study Method is called from CrewMate class.");
        System.out.println("The crewmate is studying.");
        System.out.println();
    }

    @Override
    public void maintain() {
        System.out.println("The Maintain Method is called from CrewMate class.");
        System.out.println("The crewmate is doing some maintenance tasks.");
        System.out.println();
    }
}
