package com.company;

import javax.lang.model.type.NullType;
import javax.swing.*;

public class CarFactory {
    public Car getCar(String location)
    {
        if(location.equalsIgnoreCase("Asia"))
            return new Toyota();
        else if(location.equalsIgnoreCase("Europe"))
            return new BMW();
        else
            return new Tesla();
    }
}
