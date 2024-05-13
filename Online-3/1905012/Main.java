package com.company;

import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner=new Scanner(System.in);
        int option, howManyCups;
        while (true)
        {
            System.out.println("Option-1: polyjuicePotion");
            System.out.println("Option-2: Felix Felicis");
            System.out.println("Option-3: Veritaserum ");
            System.out.println("Option-4: Skele-Gro");
            option=scanner.nextInt();
            howManyCups= scanner.nextInt();
            if(option==1)
            {
                Beverage polyjuicePotion = new BaseBeverage();
                polyjuicePotion = new PoisonIvy(polyjuicePotion);
                polyjuicePotion.getDescription();
                double subTotal=polyjuicePotion.getCost();
                Double total=howManyCups*subTotal;
                System.out.println("The price for "+howManyCups+" cups is "+total);
            }
            else if(option==2)
            {
                Beverage polyjuicePotion = new BaseBeverage();
                polyjuicePotion = new UnicornHorn(polyjuicePotion);
                polyjuicePotion.getDescription();
                double subTotal=polyjuicePotion.getCost();
                Double total=howManyCups*subTotal;
                System.out.println("The price for "+howManyCups+" cups is "+total);
            }
            else if(option==3)
            {
                Beverage polyjuicePotion = new BaseBeverage();
                polyjuicePotion = new DragonKidney(polyjuicePotion);
                polyjuicePotion.getDescription();
                double subTotal=polyjuicePotion.getCost();
                Double total=howManyCups*subTotal;
                System.out.println("The price for "+howManyCups+" cups is "+total);
            }
            else if(option==4)
            {
                Beverage polyjuicePotion = new BaseBeverage();
                polyjuicePotion = new Cabbage(polyjuicePotion);
                polyjuicePotion.getDescription();
                double subTotal=polyjuicePotion.getCost();
                Double total=howManyCups*subTotal;
                System.out.println("The price for "+howManyCups+" cups is "+total);
            }
            else

            {
                System.out.println("Please enter correct option.");
            }
        }
    }


}
