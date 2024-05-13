package com.company;

public class ReleasingState implements State{
    VendingMachine vendingMachine;

    public ReleasingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void getRequest() {
        System.out.println("The machine is not accepting any request now.");
        System.out.println("An item is going to be released");
    }

    @Override
    public void dispenseItem() {
        System.out.println("The item you paid for is given in the bucket bellow.");
        System.out.println("Thanks for choosing us.");
        vendingMachine.count = vendingMachine.count - 1;
        if(vendingMachine.count>0)
        {
            vendingMachine.setState(vendingMachine.getWaitingForRequestState());
        }
        else
        {
            vendingMachine.setState(vendingMachine.getNoProductState());
        }
    }

    @Override
    public void insertItem() {
        System.out.println("The machine will firstly release the item you paid for.");
        System.out.println("If the inventory is empty after the purchase, then try to insert again.");
    }

    @Override
    public void collectMoney() {
        System.out.println("The machine will firstly release the item you paid for.");
        System.out.println("After that, you may proceed with requesting for another item.");
    }

    @Override
    public void sendBackMoney() {
        System.out.println("The machine will firstly release the item you paid for.");
        System.out.println("If any extra amount was given, it is sent back to the money box below");
        System.out.println("Please collect from there.");
    }

    @Override
    public void printCurrentSituation() {
        System.out.print("The machine is currently in Releasing State");
        System.out.println("Inventory: "+vendingMachine.count);
        System.out.print("Until the item you paid for is released, no other operations are available.");
    }
}
