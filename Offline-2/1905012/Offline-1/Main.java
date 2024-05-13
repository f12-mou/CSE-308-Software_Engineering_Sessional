package com.company;

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
	// write your code here
        Subject abcServer = new ABCServer();
        Observer regularUser = new RegularUser(abcServer,1);
        Observer premiumUser = new PremiumUser(abcServer,1);
        int option, state;
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println();

            System.out.println("Do you want to change state of the Server?");
            System.out.println();
            System.out.println("Option-1: YES");
            System.out.println("Option-2: NO");
            option = scanner.nextInt();
            if(option<1 || option>2)
                System.out.println("Enter correct option please.");
            else if(option==2) break;
            else
            {
                System.out.println();
                System.out.println("Enter state:");
                System.out.println();
                System.out.println("Option - 1: Operational");
                System.out.println("Option - 2: Partially Down");
                System.out.println("Option - 3: Fully Down");
                state = scanner.nextInt();
                if(state<1 || state>3)
                {
                    System.out.println("Enter correct option please.");
                }
                else {
                    abcServer.setCurrState(state);
                }
            }

        }
    }
}
