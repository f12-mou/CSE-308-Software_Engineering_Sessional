package com.company;

public class BMW implements Car{
    private String color;
    private String manufacturingCompany;
    private String engine;
    private String driveTrainSystem;

    public BMW()
    {
        setParameters();
    }
    private void setParameters()
    {
        setEngine();
        setColor();
        setDriveTrainSystem();
        setManufacturingCompany();
    }

    public void setColor()
    {
        this.color = "Black";
    }
    public void setManufacturingCompany() {
        this.manufacturingCompany = "Germany";
    }
    public void setEngine()
    {
        this.engine = "Electric Engines";
    }
    public void setDriveTrainSystem()
    {
        this.driveTrainSystem = "Rear-wheel drive trains";
    }

    public void print()
    {
        System.out.println("The Specifications for BMW Car are given below:");
        System.out.println("Color: "+color);
        System.out.println("Manufacturing Company: "+manufacturingCompany);
        System.out.println("DriveTrain-System: "+driveTrainSystem);
        System.out.println("EngineCategory: "+engine);
        System.out.println("");
    }
}
