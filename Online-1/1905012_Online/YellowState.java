package com.company;

public class YellowState implements State {
    Traffic traffic;

    public YellowState(Traffic traffic)
    {
        this.traffic = traffic;
    }

    @Override
    public void change() {

    }

    @Override
    public void showColor() {
        System.out.println("Color:  YELLOW" );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        traffic.setState(traffic.getGreen());
        traffic.showColor();
    }

}
