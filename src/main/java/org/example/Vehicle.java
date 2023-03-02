package org.example;

import java.time.LocalTime;
import java.util.Date;

public class Vehicle {
    private int plateNo;
    private VType type;


    private String ticket;

    public int getPlateNo() {
        return plateNo;
    }

    public VType getType() {
        return type;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Vehicle(int plateNo, VType vType){
        this.plateNo = plateNo;
        this.type = vType;
    }

}

enum VType {
    CAR,
    TRUCK,
    MOTORCYCLE,
}