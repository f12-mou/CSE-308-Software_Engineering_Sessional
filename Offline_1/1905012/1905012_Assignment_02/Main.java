package com.company;

import java.util.Scanner;

public  class Main {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        int location;
        String[] locations = {"Asia", "United States", "Europe"};
        while(true)
        {
            System.out.println("Enter any of the following locations:");
            System.out.println("Option-1: Asia");
            System.out.println("Option-2: United States");
            System.out.println("Option-3: Europe");
            Scanner scanner=new Scanner(System.in);
            location=scanner.nextInt();
            if(location>3 || location<1)
            {
                System.out.println("Please Enter correct option"); continue;
            }
            Car car = carFactory.getCar(locations[location-1]);
            car.print();
        }
    }
}
