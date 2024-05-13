package com.company;

public class WaitingForRequestState implements State{
    VendingMachine vendingMachine;

    public WaitingForRequestState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void getRequest() {
        System.out.println("Your request is being processed.................");
        System.out.println("Please provide right amount of money to get your desired product.");
        vendingMachine.setState(vendingMachine.getCollectionMoneyState());
    }

    @Override
    public void dispenseItem() {
        System.out.println("Currently there is no request under process.");
        System.out.println("Please request for an item firstly to continue.");
    }

    @Override
    public void insertItem() {
        System.out.println("The machine is waiting for requests.");
        System.out.println("You can't insert items when the inventory is not empty");
        System.out.println("Inventory: "+vendingMachine.count);
    }

    @Override
    public void collectMoney() {
        System.out.println("Currently there is no request being processed");
        System.out.print("Please request for an item firstly to continue.");
    }

    @Override
    public void sendBackMoney() {
        System.out.println("Currently there is no request being processed");
        System.out.print("So, no extra money is in repository.");
    }

    @Override
    public void printCurrentSituation() {
        System.out.println("The machine is currently in Waiting-For-Request State");
        System.out.println("Inventory: "+vendingMachine.count);
        System.out.println("Until a request is received, no other operations are available.");
    }
}
