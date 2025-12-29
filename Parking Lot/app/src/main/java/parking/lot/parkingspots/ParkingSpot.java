package parking.lot.parkingspots;

import parking.lot.enums.VehicleType;
import parking.lot.vehicles.Vehicles;

public abstract class  ParkingSpot {
        private String spotId;
        private Vehicles vehicle;
        private boolean isAvailable;
        private double basePrice;

    public ParkingSpot(String spotId, double basePrice) {
        this.spotId=spotId;
        this.basePrice=basePrice;
        this.isAvailable=true;
    }

    public abstract void assignVehicleToParkingSpot(Vehicles vehicle);
    public abstract boolean checkIfVehicleFits(VehicleType vehicleType);

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void removeVehicleFromParkingSpot(){
        if(!isAvailable() && vehicle!=null){
            System.out.println("[+] Parking Spot "+spotId+" Free.");
            this.isAvailable=true;
            this.vehicle=null;
       }
    }

        
}
