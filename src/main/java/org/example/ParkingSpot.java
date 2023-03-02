package org.example;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class ParkingSpot {
    Size size;
    int id;
    boolean isAvailable;

    LocalTime enterTime;
    LocalTime exitTime;

    int fee;

    public ParkingSpot(Size size, int id){
        this.size = size;
        this.id = id;
        this.isAvailable = true;
    }

    public void occupy(){
        this.enterTime = LocalTime.now();
        this.isAvailable = false;
    }

    public void release(){
        this.exitTime = LocalTime.now();
        this.isAvailable = true;
    }

    public int calculateFee() {
        return (exitTime.get(ChronoField.SECOND_OF_DAY) - enterTime.get(ChronoField.SECOND_OF_DAY))*20;
    }
}

enum Size {
    COMPACT,
    REGULAR,
    LARGE,
}
