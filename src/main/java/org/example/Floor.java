package org.example;

import java.util.ArrayList;

public class Floor {
    int noOfSpots;
    int availableLargeSpots;
    int availableSmallSpots;
    int availableRegularSpots;
    ArrayList<ParkingSpot> parkingSpots;

    public Floor(int numSpots)
    {
        noOfSpots = numSpots;
        availableLargeSpots = 1;
        availableSmallSpots = 2;
        availableRegularSpots = numSpots - 3;
        parkingSpots = new ArrayList<>();
        initialize();
    }

    void initialize(){
        for(int i=0; i<noOfSpots; i++){
            parkingSpots.add(new ParkingSpot(Size.LARGE, 0));
        }

        parkingSpots.set(0,new ParkingSpot(Size.LARGE, 0));
        parkingSpots.set(1, new ParkingSpot(Size.COMPACT, 1));
        parkingSpots.set(2, new ParkingSpot(Size.LARGE, 2));
        for(int i=3; i<this.noOfSpots; i++){
            parkingSpots.set(i, new ParkingSpot(Size.REGULAR, i));
        }
    }

    public int getNoOfSpots() {
        return noOfSpots;
    }

    public int getAvailableLargeSpots() {
        return availableLargeSpots;
    }

    public int getAvailableSmallSpots() {
        return availableSmallSpots;
    }

    public int getAvailableRegularSpots() {
        return availableRegularSpots;
    }

}
