package com.company;

public class RedState implements  State{
    Traffic traffic;

    public RedState(Traffic traffic)
    {
        this.traffic = traffic;
    }

    @Override
    public void change() {

    }

    @Override
    public void showColor() {
        System.out.println("Color: RED");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        traffic.setState(traffic.getYellow());
        traffic.showColor();

    }
}
