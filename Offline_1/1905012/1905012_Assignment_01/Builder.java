package com.company;

public interface Builder {
     Builder addRam(int ramCapacity, int ramPrice);
     Builder addGraphicsCard(int cardCapacity, int cardPrice);
     Product constructPC();
     Product getConstructedPC();

     void setInitialProcessor();
     void setInitialRam();
     void setInitialBasePrice();
     void setInitialCard();
     void setType();
     int getTotalPrice();
}
