package com.company;

public class Director {
    Builder myBuilder;
    public void construct(Builder builder)
    {
        myBuilder = builder;
        myBuilder.setInitialProcessor();
        myBuilder.setInitialRam();
        myBuilder.setInitialBasePrice();
        myBuilder.setInitialCard();
        myBuilder.setType();
    }
}
