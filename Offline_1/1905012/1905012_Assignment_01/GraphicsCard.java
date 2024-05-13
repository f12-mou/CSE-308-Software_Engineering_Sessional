package com.company;

public class GraphicsCard {
    private int capacityOfCard;
    private int priceOfCard;

    public GraphicsCard()
    {

    }

    public GraphicsCard(int capacityOfCard, int priceOfCard) {
        this.capacityOfCard = capacityOfCard;
        this.priceOfCard = priceOfCard;
    }

    public int getPriceOfCard() {
        return priceOfCard;
    }

    public int getCapacityOfCard() {
        return capacityOfCard;
    }

    @Override
    public String toString() {
        return "GraphicsCard: " +
                "capacityOfCard=" + capacityOfCard +
                "GB, priceOfCard=" + priceOfCard+" BDT";
    }
}
