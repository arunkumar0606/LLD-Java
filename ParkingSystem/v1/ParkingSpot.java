public class ParkingSpot {

    private int spotNo;
    private Vehicle vehicle;
    private boolean isOccupied;

    public int getSpotNo() {
        return spotNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void clearVehicle(){
        vehicle = null;
        isOccupied=false;
        spotNo=0;
    }

    public void parkVehicle(Vehicle v, int spotNo){
        isOccupied= true;
        vehicle = v;
        this.spotNo =spotNo;

    }
}
