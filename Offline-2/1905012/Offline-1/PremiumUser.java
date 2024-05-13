package com.company;

import java.util.Scanner;

public class PremiumUser implements Observer{

    private int currState;
    private Subject server;
    private int id;
    private boolean backUpService;

    public PremiumUser(Subject server, int id)
    {
        currState = 1;
        this.server = server;
        this.id = id;
        backUpService = false;
        server.registerObserver(this);
    }
    @Override
    public void update() {
        System.out.println("Premium User, ID: "+id+" got update on server's status change.");
        System.out.println("Previous State: "+server.getName(currState));
        System.out.println("Current State: "+server.getName(server.getCurrState()));
        System.out.println();

        int prevState = currState;
        int nowState = server.getCurrState();
        Scanner scanner = new Scanner(System.in);
        int choice;

        if(prevState == 1 && nowState==2) {
            System.out.println("Do you want to use service from two companies?");
            System.out.println("Option - 1: YES");
            System.out.println("Option - 2: NO");
            while(true) {
                choice = scanner.nextInt();
                if (choice == 1) {
                    backUpService = true;
                    System.out.println("You will get service from the DEF company");
                    break;
                } else if (choice == 2) {
                    backUpService = false; break;
                } else {
                    System.out.println("Please enter correct option.");
                }
            }
        }
        else if(prevState == 1 && nowState==3)
        {
            System.out.println();
            System.out.println("As the server is fully down, service is provided by DEF company.");
            System.out.println();
        }
        else if(prevState == 2 && nowState==3)
        {
            if(backUpService == false)
            {
                System.out.println();
                System.out.println("You were not taking the backup service from DEF company");
                System.out.println("The server is fully down now.");
                System.out.println("So we have shifted the services to the DEF company.");
                backUpService = true;
            }
        }
        currState = nowState;
    }
}
