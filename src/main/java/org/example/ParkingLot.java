package org.example;

import java.util.ArrayList;

public class ParkingLot {
    int totalSpots;
    int availableSpots;
    int fee;
    int noOfFloors;
    ArrayList<Floor> floors;

    public ParkingLot(int noOfFloors){
        this.noOfFloors = noOfFloors;
        floors = new ArrayList<>();
        display();
    }

    public void addFloor(int numSpots){
        floors.add(new Floor(numSpots));
    }

    public void display(){
        System.out.println("Total Spots : + " + getTotalSpots());
    }

    public int getTotalSpots(){
        for(int i=0; i<floors.size(); i++){
            totalSpots += floors.get(i).getNoOfSpots();
        }
        return totalSpots;
    }

//    public int getAvailableSpots(){
//        for(int i=0; i<floors.size(); i++){
//            availableSpots += floors.get(i).getAvailableSpots();
//        }
//        return availableSpots;
//    }

    public String parkVehicle(int plateNo, VType vT) {
        Vehicle v = new Vehicle(plateNo, vT);

        switch (vT) {
            case CAR :
                int i = 0;
                for(i=0; i<noOfFloors; i++){
                    if(floors.get(i).availableRegularSpots > 0){
                        break;
                    }
                }

                if(i==noOfFloors){
                    System.out.println("Sorry! No space available");
                }else {
                    Floor f = floors.get(i);
                    for(int j=3; j<f.noOfSpots; j++){
                        ParkingSpot p = f.parkingSpots.get(j);
                        if (p.isAvailable) {
                            p.occupy();
                            f.availableRegularSpots -= 1;
                            return issueTicket(i, j);
                        }
                    }
                }

                break;
            case TRUCK:

                int t = 0;
                for(t=0; t<noOfFloors; t++){
                    if(floors.get(t).availableLargeSpots > 0){
                        break;
                    }
                }

                if(t==noOfFloors){
                    System.out.println("Sorry! No space available");
                }else {
                    Floor f = floors.get(t);
                    for(int j=0; j<f.noOfSpots; j++){
                        ParkingSpot p = f.parkingSpots.get(j);
                        if (p.isAvailable && p.size==Size.LARGE) {
                            p.occupy();
                            f.availableLargeSpots -= 1;
                            return  issueTicket(t, j);
                        }
                    }
                }

                break;
            case MOTORCYCLE:

                int m = 0;
                for(m=0; m<noOfFloors; m++){
                    if(floors.get(m).availableLargeSpots > 0){
                        break;
                    }
                }

                if(m==noOfFloors){
                    System.out.println("Sorry! No space available");
                }else {
                    Floor f = floors.get(m);
                    for(int j=1; j<f.noOfSpots; j++){
                        ParkingSpot p = f.parkingSpots.get(j);
                        if (p.isAvailable && p.size==Size.COMPACT) {
                            p.occupy();
                            f.availableLargeSpots -= 1;
                            return issueTicket(m, j);
                        }
                    }
                }

                break;
        }

        return "NO SPACE AVAILABLE";
    }

    public String issueTicket(int floor_no, int slot_no) {
        return floor_no + "_" + slot_no;
    }

    public void unparkVehicle(String ticket) {
        String[] tokens = ticket.split("_");
        int floor_no = Integer.parseInt(tokens[0]);
        int slot_no = Integer.parseInt(tokens[1]);

        Floor f = floors.get(floor_no);
        ParkingSpot p = f.parkingSpots.get(slot_no);
        p.release();
        p.fee = p.calculateFee();
        System.out.println(p.fee);


        if(p.size==Size.REGULAR)
            f.availableRegularSpots += 1;
        else if(p.size==Size.COMPACT)
            f.availableSmallSpots += 1;
        else if(p.size==Size.LARGE)
            f.availableLargeSpots += 1;
    }

}
