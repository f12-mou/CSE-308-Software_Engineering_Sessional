package com.company;

public class NoProductState implements State{
    VendingMachine vendingMachine;

    public NoProductState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void getRequest() {
        System.out.println("Sorry, The machine is out of products now!!! Insert quarter and try again.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Sorry, The machine is out of products now!!! No product can be dispensed.");
    }

    @Override
    public void insertItem() {
        vendingMachine.count = vendingMachine.quarter;
        System.out.println("You have inserted a bunch of "+vendingMachine.quarter+" items.");
        vendingMachine.setState(vendingMachine.getWaitingForRequestState());
    }

    @Override
    public void collectMoney() {
        System.out.println("Sorry, The machine is out of products now!!! Money collection is off.");
    }

    @Override
    public void sendBackMoney() {
        System.out.println("Sorry, The machine is out of products now!!! No money can be returned.");
    }

    @Override
    public void printCurrentSituation() {
        System.out.println("The machine is currently in No-Products-State");
        System.out.println("Inventory: "+vendingMachine.count);
        System.out.println("Until new products are inserted, no other operations are available.");
    }
}
