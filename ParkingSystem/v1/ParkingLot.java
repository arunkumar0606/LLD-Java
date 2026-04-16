import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final String name;
    private final List<ParkingSpot> spots;
    private final Map<String, ParkingSpot> vehicleMap; // O(1) lookup

    public ParkingLot(String name, int bikeSpots, int carSpots, int truckSpots) {
        this.name = name;
        this.spots = new ArrayList<>();
        this.vehicleMap = new HashMap<>();

        int spotNo = 1;

        // Pre-create spots
        for (int i = 0; i < bikeSpots; i++)
            spots.add(new ParkingSpot(spotNo++, VehicleType.BIKE));

        for (int i = 0; i < carSpots; i++)
            spots.add(new ParkingSpot(spotNo++, VehicleType.CAR));

        for (int i = 0; i < truckSpots; i++)
            spots.add(new ParkingSpot(spotNo++, VehicleType.TRUCK));
    }

    public void park(Vehicle v) {
        if (vehicleMap.containsKey(v.getRegistrationNumber())) {
            System.out.println("Vehicle already parked!");
            return;
        }

        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.canFit(v)) {
                spot.park(v);
                vehicleMap.put(v.getRegistrationNumber(), spot);
                System.out.println("Parked " + v.getRegistrationNumber() + " at Spot " + spot.getSpotNo());
                return;
            }
        }

        System.out.println("No available spot for vehicle type: " + v.getType());
    }

    public void unpark(String registrationNumber) {
        ParkingSpot spot = vehicleMap.get(registrationNumber);

        if (spot == null) {
            System.out.println("Vehicle not found!");
            return;
        }

        spot.unpark();
        vehicleMap.remove(registrationNumber);

        System.out.println("Unparked vehicle from Spot " + spot.getSpotNo());
    }

    public List<Vehicle> getParkedVehicles() {
        List<Vehicle> result = new ArrayList<>();
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable()) {
                result.add(spot.getVehicle());
            }
        }
        return result;
    }
}