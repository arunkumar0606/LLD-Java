

public class Customer {
    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot("Phoenix", 2, 2, 1);

        Vehicle bike = new Vehicle("234", VehicleType.BIKE);
        Vehicle car = new Vehicle("444", VehicleType.CAR);
        Vehicle truck = new Vehicle("6666", VehicleType.TRUCK);
        Vehicle bike2 = new Vehicle("2234", VehicleType.BIKE);
        Vehicle bike3 = new Vehicle("5234", VehicleType.BIKE);

        lot.park(bike);
        lot.park(car);
        lot.park(truck);
        lot.park(bike2);
        lot.park(bike3); // should fail (bike spots full)

        lot.unpark("444");

        lot.park(new Vehicle("999", VehicleType.CAR));

        System.out.println(lot.getParkedVehicles());


    }
}
