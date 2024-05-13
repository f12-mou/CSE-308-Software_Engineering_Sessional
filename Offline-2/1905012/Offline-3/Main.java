package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        VendingMachine vendingMachine = new VendingMachine(0, 1000,500);

        // Trying to request for an item fails as the machine has no product now.
        vendingMachine.getRequest();

        // Inserting a quarter defined as above parameter
        vendingMachine.insertItem();

        // Now it will receive a request
        vendingMachine.getRequest();

        // The following command will prompt for money
        vendingMachine.collectMoney();

        // Collect Money command ensures to get the exact amount of money
        vendingMachine.dispenseItem();

        // Printing the current situation
        vendingMachine.print();

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println();
            System.out.println("Enter an option:");
            System.out.println("1. Insert a Quarter");
            System.out.println("2. Get a Request");
            System.out.println("3. Collect Money from User");
            System.out.println("4. Dispense the item");
            System.out.println("5. Print current Situation");
            int option;
            option = scanner.nextInt();
            System.out.println();
            if(option == 1)
            {
                vendingMachine.insertItem();
            }
            else if(option == 2)
            {
                vendingMachine.getRequest();
            }
            else if(option == 3)
            {
                vendingMachine.collectMoney();
            }
            else if(option == 4)
            {
                vendingMachine.dispenseItem();
            }
            else if(option == 5)
            {
                vendingMachine.print();
            }

        }

    }
}
