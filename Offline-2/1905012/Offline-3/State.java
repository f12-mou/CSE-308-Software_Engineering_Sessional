package com.company;

public interface State {
    void getRequest();
    void dispenseItem();
    void insertItem();
    void collectMoney();
    void sendBackMoney();
    void printCurrentSituation();
}
