public class ParkingSpot {
    private final int spotNo;
    private final VehicleType supportedType;
    private Vehicle vehicle;

    public ParkingSpot(int spotNo, VehicleType type) {
        this.spotNo = spotNo;
        this.supportedType = type;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFit(Vehicle v) {
        return v.getType() == supportedType;
    }

    public void park(Vehicle v) {
        this.vehicle = v;
    }

    public void unpark() {
        this.vehicle = null;
    }

    public int getSpotNo() {
        return spotNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getSupportedType() {
        return supportedType;
    }
}
