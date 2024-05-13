package com.company;

public interface Subject {
     void registerObserver(Observer o);
     void notifyObservers();
     void setCurrState(int currState);
     int getCurrState();
     String getName(int state);
}
