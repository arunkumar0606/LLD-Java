public class TicketPrice {
    private final VehicleType type;
    public TicketPrice(VehicleType type){
        this.type= type;
    }

    public int getFixedPrice(){
        return switch(type){
            case BIKE -> 5;
            case CAR -> 10;
            case TRUCK -> 15;
        };
    }
}
