package com.company;

import java.util.ArrayList;

public class ABCServer implements Subject{
    private ArrayList<Observer>observers;
    private int currState;

    public ABCServer()
    {
        currState = 1; // Beginning State: Operational
        observers = new ArrayList<Observer>();
    }

    @Override
    public int getCurrState() {
        return currState;
    }

    @Override
    public void setCurrState(int currState) {
        if(currState != this.currState) {
            this.currState = currState;
            // System.out.println(this.currState);
            stateChanged();
        }
    }

    public void stateChanged()
    {
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for(int i=0;i<observers.size();i++)
        {
            Observer observer = observers.get(i);
            observer.update();
        }
    }
    @Override
    public String getName(int state)
    {
        if(state == 1) return "Operational";
        else if (state == 2) return "Partially Down";
        else return "Fully Down";
    }
}
