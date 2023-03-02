package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ParkingLot PL = new ParkingLot(3);
        PL.addFloor(10);
        PL.addFloor(10);
        PL.addFloor(10);

        PL.display();
        String t1 = PL.parkVehicle(123, VType.CAR);
        Thread.sleep(5);
        PL.unparkVehicle(t1);

    }
}