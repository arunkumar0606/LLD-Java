public class Vehicle {
    private final String registrationNumber;
    private VehicleType vehicle;

    public Vehicle(String regNo,Vehicle vehicle){
        registrationNumber=regNo;
        this.vehicle=vehicle;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
