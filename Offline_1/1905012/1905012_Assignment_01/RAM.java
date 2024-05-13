package com.company;

public class RAM {
    private int capacityOfRam;
    private int priceOfRAM;
    public RAM(int capacityOfRam, int priceOfRAM) {
        this.capacityOfRam = capacityOfRam;
        this.priceOfRAM = priceOfRAM;
    }
    public RAM()
    {

    }

    public int getPriceOfRAM() {
        return priceOfRAM;
    }

    @Override
    public String toString() {
        return "RAM: " +
                "capacityOfRam=" + capacityOfRam +
                "MHz, priceOfRAM=" + priceOfRAM+" BDT";
    }
}

