public class Vehicle {
    private final String registrationNumber;
    private final VehicleType type;

    public Vehicle(String regNo, VehicleType type) {
        this.registrationNumber = regNo;
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{ " + registrationNumber + " , " + type + " }";
    }
}