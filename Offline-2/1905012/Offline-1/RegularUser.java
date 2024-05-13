package com.company;

import java.util.Scanner;

public class RegularUser implements Observer{

    private int currState;
    private Subject server;
    private int id;
    private boolean backUpService;

    public RegularUser(Subject server, int id)
    {
        currState = 1;
        this.server = server;
        this.id = id;
        server.registerObserver(this);
    }
    @Override
    public void update() {
        System.out.println("Regular User, ID: "+id+" got update on server's status change.");
        System.out.println("Previous State: "+server.getName(currState));
        System.out.println("Current State: "+server.getName(server.getCurrState()));
        System.out.println();

        int prevState = currState;
        int nowState = server.getCurrState();
        Scanner scanner = new Scanner(System.in);
        int choice;

        if(prevState == 1 && nowState==2) {
            System.out.println("Choose your convenient option:");
            System.out.println("Option - 1: Continue Using limited Functionality.");
            System.out.println("Option - 2: Pay $20 per hour to enjoy full functionality using service from DEF company.");
            while(true) {
                choice = scanner.nextInt();
                if (choice == 1) {
                    backUpService = false; break;
                } else if (choice == 2) {
                    backUpService = true; break;
                } else {
                    System.out.println("Please enter correct option.");
                }
            }
        }
        else if(prevState == 1 && nowState==3)
        {
            System.out.println();
            System.out.println("Do you want to take service from DEF company paying $20 per hour?");
            System.out.println("Option - 1: YES");
            System.out.println("Option - 2: NO");
            while(true) {
                choice = scanner.nextInt();
                if (choice == 1) {
                    backUpService = true; break;
                } else if (choice == 2) {
                    backUpService = false; break;
                } else {
                    System.out.println("Please enter correct option.");
                }
            }
        }
        else if(prevState == 2 && nowState==1) // partially down -> operational, send bills if backup was on
        {
            if(backUpService == true)
            {
                System.out.println();
                System.out.println("You were taking the backup service from DEF company");
                System.out.println("The ABC server is operational now.");
                System.out.println("So please pay $X to the DEF company for the previous backup.");
                backUpService = false;
            }
        }
        else if(prevState == 3 && nowState==1) // fully down -> operational, send bills if backup was on
        {
            if(backUpService == true)
            {
                System.out.println();
                System.out.println("You were taking the backup service from DEF company");
                System.out.println("The ABC server is operational now.");
                System.out.println("So please pay $X to the DEF company for the previous backup.");
                backUpService = false;
            }
        }
        currState = nowState;
    }
}
