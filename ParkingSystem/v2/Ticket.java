import java.time.Duration;
import java.time.LocalTime;
import java.util.UUID;

public class Ticket {
    private final String ticketNumber;
    private final String vehicleNumber;
    private final LocalTime startTime;
    private final ParkingSpot spot;
    private int ticketPrice;

    public Ticket( String vehicleNumber, LocalTime startTime, ParkingSpot spot) {
        this.ticketNumber = UUID.randomUUID().toString().substring(0,5);
        this.vehicleNumber = vehicleNumber;
        this.startTime = startTime;
        this.spot = spot;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public int getTicketPrice(){
        int timeSpent = (int) (Duration.between(LocalTime.now(),startTime).getNano() / 36000000);
        TicketPrice price = new TicketPrice(spot.getVehicle().getType());
        return price.getFixedPrice() * timeSpent;
    }

}
