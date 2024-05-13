package com.company;

public class Processor {
    private String modelOfProcessor;
    private int priceOfProcessor;
    public Processor(String modelOfProcessor, int priceOfProcessor){
        this.modelOfProcessor = modelOfProcessor;
        this.priceOfProcessor = priceOfProcessor;
    }

    @Override
    public String toString() {
        return "Specs of Processor is : " +
                "modelOfProcessor='" + modelOfProcessor + '\'' +
                ", priceOfProcessor=" + priceOfProcessor+" BDT";
    }
}
