

public class Customer {
    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot("Phoenix",5);


        Vehicle bike = new Vehicle("234",VehicleType.BIKE);
        Vehicle car = new Vehicle("444",VehicleType.CAR);
        Vehicle truck = new Vehicle("6666", VehicleType.TRUCK);
        Vehicle bike2 = new Vehicle("2234",VehicleType.BIKE);
        Vehicle bike3 = new Vehicle("5234",VehicleType.BIKE);
        Vehicle bike4 = new Vehicle("f5234",VehicleType.BIKE);

        lot.park(bike,1);
        lot.park(car,2);
        lot.park(truck,3);
        lot.park(bike2,4);
        lot.park(bike3,5);
        lot.park(bike4,6);


        lot.unPark(car);

        lot.park(car,2);

        System.out.println(lot.parkedVehicles());


    }
}
