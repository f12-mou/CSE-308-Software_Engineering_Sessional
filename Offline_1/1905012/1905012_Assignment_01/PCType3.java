package com.company;

public class PCType3 implements Builder{
    private int PCType;
    private Processor processor;
    private int basePrice;
    private boolean isRamIncluded;
    private RAM ram;
    private boolean isGraphicsCardIncluded;
    private GraphicsCard graphicsCard;
    private Product product;

    @Override
    public Builder addRam(int ramCapacity, int ramPrice) {

        this.isRamIncluded = true;
        this.ram = new RAM(ramCapacity, ramPrice);
        return this;
    }

    @Override
    public Builder addGraphicsCard(int cardCapacity, int cardPrice) {
        isGraphicsCardIncluded = true;
        this.graphicsCard = new GraphicsCard(cardCapacity, cardPrice);
        return this;
    }

    @Override
    public Product constructPC() {
        this.product = new Product(this.processor, this.basePrice, this.isRamIncluded, this.ram,
                this.isGraphicsCardIncluded, this.graphicsCard, this.PCType);
        return this.product;
    }

    @Override
    public Product getConstructedPC() {
        return this.product;
    }

    @Override
    public void setInitialProcessor() {
        this.processor = new Processor("11th Generation Intel Core i7", 37000);
    }

    @Override
    public void setInitialRam() {
        isRamIncluded = false;
        ram = new RAM();
    }

    @Override
    public void setInitialBasePrice() {
        basePrice = 70000;
    }

    @Override
    public void setInitialCard() {
        isGraphicsCardIncluded = false;

        graphicsCard = new GraphicsCard();
    }

    @Override
    public void setType() {
        PCType = 3;
    }

    @Override
    public int getTotalPrice() {
        int additionalPrice = 6000; // DVD Drive
        int totalPrice = basePrice;
        if(isRamIncluded)
            totalPrice += this.ram.getPriceOfRAM();
        if(isGraphicsCardIncluded)
            totalPrice += this.graphicsCard.getPriceOfCard();
        return additionalPrice + totalPrice;
    }
}

