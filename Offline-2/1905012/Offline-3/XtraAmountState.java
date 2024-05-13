package com.company;

public class XtraAmountState implements State{
    VendingMachine vendingMachine;

    public XtraAmountState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void getRequest() {
        System.out.println("The machine is not accepting any request now");
    }

    @Override
    public void dispenseItem() {
        System.out.println("The extra amount is going to be sent back first, please wait.");
    }

    @Override
    public void insertItem() {
        System.out.println("If the inventory becomes empty after releasing the item, then try again.");
    }

    @Override
    public void collectMoney() {
        System.out.println("The machine is not accepting any money now.");
    }

    @Override
    public void sendBackMoney() {
        //System.out.println(vendingMachine.mismatchAmount);
        if(vendingMachine.mismatchAmount>0) {
            System.out.println("You paid " + vendingMachine.mismatchAmount + " taka extra which is sent back to you");
            System.out.println("Please collect it from the money box below");
        }
        vendingMachine.mismatchAmount=0;
        vendingMachine.setState(vendingMachine.getReleasingState());
    }

    @Override
    public void printCurrentSituation() {
        System.out.println("The machine is currently in Extra-Amount-Taken State");
        System.out.println("Inventory: "+vendingMachine.count);
        System.out.println("You will get your exchange and then other operations will be available again.");
    }
}
