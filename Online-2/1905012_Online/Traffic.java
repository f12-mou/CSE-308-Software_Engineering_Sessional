package com.company;

public class Traffic {
    State red = null;
    State green = null;

    public State getYellow() {
        return yellow;
    }

    public void setYellow(State yellow) {
        this.yellow = yellow;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    State yellow = null;
    State state=red;

    public State getRed() {
        return red;
    }

    public void setRed(State red) {
        this.red = red;
    }

    public State getGreen() {
        return green;
    }

    public void setGreen(State green) {
        this.green = green;
    }

    public Traffic()
    {
        red=new RedState(this);
        green = new GreenState(this);
        yellow = new YellowState(this);
        state =red;
    }
    public void showColor()
    {
        state.showColor();
    }

}
