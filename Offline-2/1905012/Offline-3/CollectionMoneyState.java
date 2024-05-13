package com.company;
import java.util.Scanner;

public class CollectionMoneyState implements State{
    VendingMachine vendingMachine;

    public CollectionMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void getRequest() {
        System.out.println("Please try again after the current processing is done.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please provide money firstly.");
    }

    @Override
    public void insertItem() {
        System.out.println("The machine will be collecting money. Try again later.");
    }

    @Override
    public void collectMoney() {
        System.out.println();
        System.out.println("Please insert amount "+ vendingMachine.price+" taka");
        int price = 0;
        Scanner scanner = new Scanner(System.in);
        price = scanner.nextInt();
        if(price < vendingMachine.price)
        {
            System.out.println("You have inserted amount "+price+" taka which is less than "+vendingMachine.price+" taka");
            vendingMachine.mismatchAmount = vendingMachine.price - price;
            while(vendingMachine.mismatchAmount!=0)
            {
                System.out.println("Please insert "+ vendingMachine.mismatchAmount +" taka more");
                price = scanner.nextInt();
                if(price == vendingMachine.mismatchAmount)
                {
                    System.out.println();
                    System.out.println("An item is being released........");
                    vendingMachine.setState(vendingMachine.getReleasingState());
                    break;
                }
                else if(price > vendingMachine.mismatchAmount)
                {
                    System.out.println();
                    System.out.println("You have inserted amount "+price+" which is greater than "+vendingMachine.mismatchAmount);
                    vendingMachine.mismatchAmount = price - vendingMachine.mismatchAmount;
                    State state = vendingMachine.getXtraAmountState();
                    vendingMachine.setState(state);
                    vendingMachine.sendBackMoney();
                    break;
                }
                else
                {
                    vendingMachine.mismatchAmount = vendingMachine.mismatchAmount-price;
                }

            }
        }
        else if(price == vendingMachine.price)
        {
            System.out.println();
            System.out.println("An item is being released........");
            vendingMachine.setState(vendingMachine.getReleasingState());
        }
        else
        {
            System.out.println();
            System.out.println("You have inserted amount "+price+" which is greater than "+vendingMachine.price);
            vendingMachine.mismatchAmount = price - vendingMachine.price;
            State state = vendingMachine.getXtraAmountState();
            vendingMachine.setState(state);
            state.sendBackMoney();
        }
    }

    @Override
    public void sendBackMoney() {
        System.out.println();
        System.out.println("You have not provided any amount.");
        System.out.println("No extra money is in repository.");

    }

    @Override
    public void printCurrentSituation() {
        System.out.println();
        System.out.println("The machine is currently in Collecting Money State");
        System.out.println("Inventory: "+vendingMachine.count);
        System.out.println("Until any amount is provided, no other operations are available.");
    }
}
