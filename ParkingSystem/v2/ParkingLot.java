import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final String name;
    private final List<ParkingSpot> spots;
    private final Map<String, Ticket> ticketMap;

    public ParkingLot(String name, int bikeSpots, int carSpots, int truckSpots) {
        this.name = name;
        this.spots = new ArrayList<>();
        this.ticketMap = new HashMap<>();

        int spotNo = 1;

        // Pre-create spots
        for (int i = 0; i < bikeSpots; i++)
            spots.add(new ParkingSpot(spotNo++, VehicleType.BIKE));

        for (int i = 0; i < carSpots; i++)
            spots.add(new ParkingSpot(spotNo++, VehicleType.CAR));

        for (int i = 0; i < truckSpots; i++)
            spots.add(new ParkingSpot(spotNo++, VehicleType.TRUCK));
    }

    public Ticket park(Vehicle v) {
        if (ticketMap.containsKey(v)) {
            System.out.println("Vehicle already parked!");
            return ticketMap.get(v);
        }

        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.canFit(v)) {
                spot.park(v);
                Ticket t = new Ticket(v.getRegistrationNumber(), LocalTime.now(),spot);
                ticketMap.put(v.getRegistrationNumber(),t);
                System.out.println("Parked " + v.getRegistrationNumber() + " at Spot " + spot.getSpotNo() + " Ticket : " + t.getTicketNumber());
                return t;
            }
        }

        System.out.println("No available spot for vehicle type: " + v.getType());
        return null;
    }

    public int unpark(Ticket t) {
        int price = t.getTicketPrice();
        ParkingSpot spot = t.getSpot();
        spot.unpark();
        ticketMap.remove(t.getVehicleNumber());
        System.out.println("Unparked vehicle from Spot " + spot.getSpotNo());
        return price;
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