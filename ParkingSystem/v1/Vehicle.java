public class Vehicle {
    private final String registrationNumber;
    private VehicleType vehicle;

    public Vehicle(String regNo,VehicleType vehicle){
        registrationNumber=regNo;
        this.vehicle=vehicle;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleType vehicle) {
        this.vehicle = vehicle;
    }
}
