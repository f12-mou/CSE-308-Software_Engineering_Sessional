package com.company;

import java.awt.desktop.ScreenSleepEvent;

public class Tesla implements Car{
    private String color;
    private String manufacturingCompany;
    private String engine;
    private String driveTrainSystem;
    public Tesla()
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
        this.color = "White";
    }
    public void setManufacturingCompany() {
        this.manufacturingCompany = "US";
    }
    public void setEngine()
    {
        this.engine = "Electric Engines";
    }
    public void setDriveTrainSystem()
    {
        this.driveTrainSystem = "All-wheels drive trains";
    }

    public void print()
    {
        System.out.println("The Specifications for Tesla Car are given below:");
        System.out.println("Color: "+color);
        System.out.println("Manufacturing Company: "+manufacturingCompany);
        System.out.println("DriveTrain-System: "+driveTrainSystem);
        System.out.println("EngineCategory: "+engine);
        System.out.println("");
    }
}
