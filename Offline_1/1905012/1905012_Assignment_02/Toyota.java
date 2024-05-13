package com.company;

public class Toyota implements Car
{
    private String color;
    private String manufacturingCompany;
    private String engine;
    private String driveTrainSystem;
    public Toyota()
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
        this.color = "Red";
    }
    public void setManufacturingCompany() {
        this.manufacturingCompany = "Japan";
    }
    public void setEngine()
    {
        this.engine = "Hydrogen Fuel Cells";
    }
    public void setDriveTrainSystem()
    {
        this.driveTrainSystem = "Rear-wheel drive trains";
    }

    public void print()
    {
        System.out.println("The Specifications for Toyota Car are given below:");
        System.out.println("Color: "+color);
        System.out.println("Manufacturing Company: "+manufacturingCompany);
        System.out.println("DriveTrain-System: "+driveTrainSystem);
        System.out.println("EngineCategory: "+engine);
        System.out.println("");
    }

}