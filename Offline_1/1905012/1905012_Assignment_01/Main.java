package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("The Catalog is shown below----------------------");
        System.out.println("");
        Director director = new Director();
        Builder builder1 = new PCType1();
        director.construct(builder1);
        Product product1 = builder1.constructPC();
        product1.print();

        Builder builder2 = new PCType2();
        director.construct(builder2);
        Product product2 = builder2.constructPC();
        product2.print();

        Builder builder3 = new PCType3();
        director.construct(builder3);
        Product product3 = builder3.constructPC();
        product3.print();

        Builder builder4 = new PCType4();
        director.construct(builder4);
        builder4.addRam(5600,7900);
        Product product4 = builder4.constructPC();
        product4.print();

        int[] RamCapacity = {2666, 3200};
        int[] RamPrice = {2620, 2950};
        int[] GraphicsCardCapacity = {2, 4};
        int[] GraphicsCardPrice = {6500, 7600};


        while(true)
        {
            System.out.println("Enter any of the 2 options:");
            System.out.println("1. O for opening a new Order");
            System.out.println("2. E for exiting orders.");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            int total = 0;

            if(option == 1)
            {
                List<Product> list = new ArrayList<Product>();
                total = 0;
                while(true) {
                    if(list.size()>0)
                    {
                        System.out.println("Do you want to close this order?");
                        System.out.println("1. YES");
                        System.out.println("2. NO");
                        int nowOption = scanner.nextInt();
                        if(nowOption == 1)
                        {
                            for(Product product:list)
                            {
                                product.print();
                            }
                            System.out.println("The total Price of your items are " + total+" BDT");
                            total = 0;
                            break;
                        }
                    }
                    System.out.println("Enter type of PC");
                    int type = scanner.nextInt();
                    Builder builder = null;
                    if (type == 1) {
                        builder = new PCType1();
                    } else if (type == 2) {
                        builder = new PCType2();
                    } else if (type == 3) {
                        builder = new PCType3();
                    } else {
                        builder = new PCType4();
                    }
                    director.construct(builder);
                    System.out.println("Do you want to add extra RAM?");
                    System.out.println("Enter option: ");
                    for (int i = 0; i < 2; i++)
                        System.out.println((i + 1) + ": " + RamCapacity[i] + " MHz " + RamPrice[i] + " BDT");
                    System.out.println("3. Not needed.");
                    int RamOption = scanner.nextInt();
                    if (RamOption <= RamCapacity.length) {
                        builder = builder.addRam(RamCapacity[RamOption-1], RamPrice[RamOption-1]);
                    }

                    System.out.println("Do you want to add extra Graphics Card?");
                    System.out.println("Enter option: ");
                    for (int i = 0; i < 2; i++)
                        System.out.println((i + 1) + ": " + GraphicsCardCapacity[i] + " GB " + GraphicsCardPrice[i] + " BDT");
                    System.out.println("3: Not needed.");
                    int CardOption = scanner.nextInt();
                    if (CardOption <= GraphicsCardPrice.length) {
                        builder = builder.addGraphicsCard(GraphicsCardCapacity[CardOption-1], GraphicsCardPrice[CardOption-1]);
                    }
                    Product product = builder.constructPC();
                    total = total + builder.getTotalPrice();
                    list.add(product);
                }
            }
            else
            {
                break;
            }
        }
    }
}
