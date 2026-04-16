

public class Customer {
    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot("Phoenix", 2, 2, 1);

        Vehicle bike = new Vehicle("234", VehicleType.BIKE);
        Vehicle car = new Vehicle("444", VehicleType.CAR);
        Vehicle truck = new Vehicle("6666", VehicleType.TRUCK);
        Vehicle bike2 = new Vehicle("2234", VehicleType.BIKE);
        Vehicle bike3 = new Vehicle("5234", VehicleType.BIKE);

        Ticket t1 = lot.park(bike);
        Ticket t2 = lot.park(car);
        Ticket t3 = lot.park(truck);
        Ticket t4 = lot.park(bike2);
        Ticket t5 = lot.park(bike3);

        int price = lot.unpark(t1);
        int price2 = lot.unpark(t2);
        int price3 = lot.unpark(t3);
        System.out.printf("Price to be paid for bike: $%d%n", price);
        System.out.printf("Price to be paid for car: $%d%n",price2);
        System.out.printf("Price to be paid for truck: $%d%n ",price3);

        lot.park(new Vehicle("999", VehicleType.CAR));

        System.out.println(lot.getParkedVehicles());


    }
}
