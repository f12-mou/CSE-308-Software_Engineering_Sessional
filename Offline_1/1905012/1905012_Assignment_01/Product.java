package com.company;

public class Product {
    private int PCType;
    private Processor processor;
    private int basePrice;
    private boolean isRamIncluded;
    private RAM ram;
    private boolean isGraphicsCardIncluded;
    private GraphicsCard graphicsCard;

    public Product(Processor processor, int basePrice, boolean isRamIncluded, RAM ram, boolean isGraphicsCardIncluded, GraphicsCard graphicsCard, int pcType) {
        this.processor = processor;
        this.basePrice = basePrice;
        this.isRamIncluded = isRamIncluded;
        this.ram = ram;
        this.isGraphicsCardIncluded = isGraphicsCardIncluded;
        this.graphicsCard = graphicsCard;
        this.PCType = pcType;
    }


    public void print() {
        int total = basePrice;
        System.out.println("The type of PC is : " + PCType + " ................");
        System.out.println("Base Components are:");
        System.out.println(processor);
        System.out.println("The base Price of this PC is: " + basePrice);
        if(PCType==1)
        {
            System.out.println("This PC has a CPU Cooler with additional 36000 BDT");
            total = total + 36000;
        }
        else if(PCType == 2)
        {
            System.out.println("This PC has a liquid Cooler with additional 17000 BDT");
            total = total + 17000;
        }
        else if(PCType == 3)
        {
            System.out.println("This PC has a DVD Drive with additional 6000 BDT");
            total = total + 6000;
        }
        System.out.println("The additional Customized Components are: ");
        if (isRamIncluded) {
            System.out.println(ram);
            total = total + ram.getPriceOfRAM();
        }
        if (isGraphicsCardIncluded) {
            System.out.println(graphicsCard);
            total = total + graphicsCard.getPriceOfCard();
        }
        if(!isRamIncluded && !isGraphicsCardIncluded)
        {
            System.out.println("N/A");
        }
    }
}

