import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private List<ParkingSpot> slots;
    private final int maxSlots;

    public ParkingLot(String name , int maxSlots){
        this.name=name;
        this.maxSlots=maxSlots;
        slots= new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void park(Vehicle v , int slot){
        if(slots.size() == maxSlots){
            System.out.println("Spots are full , please wait !");
            return;
        }
        for (ParkingSpot spot : slots){
            if(spot.getSpotNo() == slot){
                System.out.println("Spot already occupied , try different spot !");
                return;
            }
        }
        ParkingSpot spot = new ParkingSpot();
        spot.parkVehicle(v,slot);
        slots.add(spot);
        System.out.println( "Parked Vehicle "+v.getRegistrationNumber()+" @Spot :"+spot.getSpotNo());
    }
    public void unPark(Vehicle v ){

        for(ParkingSpot spot : slots){
            if(spot.getVehicle().getRegistrationNumber() == v.getRegistrationNumber()){
                System.out.println( "Unparked Succesfully @ Spot : "+spot.getSpotNo());
                slots.remove(spot);
                spot.clearVehicle();
                return;
            }

        }
        System.out.println( "Vehicle not Found !!");

    }
    public List<Vehicle> parkedVehicles(){
        List<Vehicle> v = new ArrayList<>();
        slots.forEach( x-> v.add(x.getVehicle()));
        return v;
    }

}
