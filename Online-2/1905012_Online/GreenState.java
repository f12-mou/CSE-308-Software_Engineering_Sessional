package com.company;

public class GreenState implements State{
    Traffic traffic;

    public GreenState(Traffic traffic)
    {
        this.traffic = traffic;
    }

    @Override
    public void change() {

    }

    @Override
    public void showColor() {
        System.out.println("Color:  GREEN" );
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        traffic.setState(traffic.getRed());
        traffic.showColor();
    }
}
