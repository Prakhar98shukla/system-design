package parking.lot.parkingspots;

import parking.lot.enums.VehicleType;
import parking.lot.vehicles.Vehicles;

public class TwoWheelerSpot extends ParkingSpot{

     public TwoWheelerSpot(String spotId) {
        super(spotId,20);
    }
    
    public void assignVehicleToParkingSpot(Vehicles vehicle){
        if(isAvailable()){
            System.out.println("\n[+] A TWO_WheelerSpot "+getSpotId()+" is Occupied by "+vehicle.getVehicleNo());
            setVehicle(vehicle);
            setAvailable(false);
        }
    }

    public boolean checkIfVehicleFits(VehicleType vehicleType){
        return vehicleType== VehicleType.TWO_WHEELER;
    }

}
