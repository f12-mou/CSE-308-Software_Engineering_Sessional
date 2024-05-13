package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int orderNo = 1;
        while(true)
        {
            int cntAmericano=0, cntEspresso=0, cntCappu=0, cntMocha=0;
            Beverage americano, espresso, cappucino, mocha;
            Beverage prodAmericano = null, prodEspresso=null, prodCappucino=null, prodMocha=null;
            Scanner scanner=new Scanner(System.in);
            int option=0, cnt=0;

            System.out.println("Do you want to place an order?");
            System.out.println("Option-1: YES");
            System.out.println("Option-2: NO");
            option=scanner.nextInt();
            if(option==1)
            {
                System.out.println("The following beverages are available.");
                System.out.println("    1. Americano");
                System.out.println("    2. Espresso");
                System.out.println("    3. Cappucino");
                System.out.println("    4. Mocha");

                System.out.println("Do you want to add Americano?");
                System.out.println("Option-1: YES");
                System.out.println("Option-2: NO");
                option=scanner.nextInt();
                if(option==1)
                {
                    System.out.println("How many cups do you want to add Americano?");
                    cnt=scanner.nextInt();
                    if(cnt>0)
                    {
                        americano=new BlackCoffee();
                        prodAmericano = new CoffeeBeans(americano);
                        cntAmericano = cnt;
                    }
                }

                System.out.println("Do you want to add Espresso?");
                System.out.println("Option-1: YES");
                System.out.println("Option-2: NO");
                option=scanner.nextInt();
                if(option==1)
                {
                    System.out.println("How many cups do you want to add Espresso?");
                    cnt=scanner.nextInt();
                    if(cnt>0)
                    {
                        espresso =new BlackCoffee();
                        prodEspresso = new DairyCream(espresso);
                        cntEspresso = cnt;
                    }
                }

                System.out.println("Do you want to add Cappucino?");
                System.out.println("Option-1: YES");
                System.out.println("Option-2: NO");
                option=scanner.nextInt();
                if(option==1)
                {
                    System.out.println("How many cups do you want to add Cappucino?");
                    cnt=scanner.nextInt();
                    if(cnt>0)
                    {
                        cappucino=new MilkCoffee();
                        prodCappucino = new CinnamonPowder(cappucino);
                        cntCappu = cnt;
                    }
                }

                System.out.println("Do you want to add Mocha?");
                System.out.println("Option-1: YES");
                System.out.println("Option-2: NO");
                option=scanner.nextInt();
                if(option==1)
                {
                    System.out.println("How many cups do you want to add Mocha?");
                    cnt=scanner.nextInt();
                    if(cnt>0)
                    {
                        mocha=new MilkCoffee();
                        prodMocha = new ChocolateSauce(mocha);
                        cntMocha = cnt;
                    }
                }
                if(cntAmericano+cntCappu+cntEspresso+cntMocha>0)
                {
                    int total=0;
                    if(cntAmericano>0)
                    {
                        System.out.println();
                        System.out.println("Details about Americano --------------");
                        System.out.println();
                        prodAmericano.printDescription();
                        System.out.println();
                        System.out.println("Unit Price: "+prodAmericano.getCost() +" taka");
                        System.out.println("Total units: "+cntAmericano);
                        System.out.println("Total Price for Americano: "+cntAmericano* prodAmericano.getCost()+" taka");
                        total+=(cntAmericano* prodAmericano.getCost());
                    }
                    if(cntEspresso>0)
                    {
                        System.out.println();
                        System.out.println("Details about Espresso --------------");
                        System.out.println();
                        prodEspresso.printDescription();
                        System.out.println();
                        System.out.println("Unit Price: "+prodEspresso.getCost()+" taka");
                        System.out.println("Total units: "+cntEspresso);
                        System.out.println("Total Price for Espresso: "+cntEspresso* prodEspresso.getCost()+" taka");
                        total+=(cntEspresso* prodEspresso.getCost());
                    }
                    if(cntCappu>0)
                    {
                        System.out.println();
                        System.out.println("Details about Cappucino --------------");
                        System.out.println();
                        prodCappucino.printDescription();
                        System.out.println();
                        System.out.println("Unit Price: "+prodCappucino.getCost()+" taka");
                        System.out.println("Total units: "+cntCappu);
                        System.out.println("Total Price for Cappucino: "+cntCappu* prodCappucino.getCost()+" taka");
                        total+=(cntCappu* prodCappucino.getCost());
                    }
                    if(cntMocha>0)
                    {
                        System.out.println();
                        System.out.println("Details about Mocha --------------");
                        System.out.println();
                        prodMocha.printDescription();
                        System.out.println();
                        System.out.println("Unit Price: "+prodMocha.getCost()+" taka");
                        System.out.println("Total units: "+cntMocha);
                        System.out.println("Total Price for Mocha: "+cntMocha* prodMocha.getCost()+" taka");
                        total+=(cntMocha* prodMocha.getCost());
                    }
                    System.out.println("Processing Order No: "+orderNo);
                    orderNo+=1;
                    System.out.println("-----------------------------------------------");
                    System.out.println("Total Price is: "+total+" taka only.");
                    System.out.println();
                }

            }
            else if(option==2)
            {
                break;
            }
            else
            {
                System.out.println("Please Enter correct option.");
            }

        }

    }
}
