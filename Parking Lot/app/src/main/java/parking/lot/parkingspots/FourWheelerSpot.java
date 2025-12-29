package parking.lot.parkingspots;

import parking.lot.enums.VehicleType;
import parking.lot.vehicles.Vehicles;

public class FourWheelerSpot extends ParkingSpot {

    public FourWheelerSpot(String spotId) {
        super(spotId, 40);
    }
    
    public void assignVehicleToParkingSpot(Vehicles vehicle){
        if(isAvailable()){
            System.out.println("\n[+] A FourWheelerSpot "+getSpotId()+" is Occupied by "+vehicle.getVehicleNo());
            setVehicle(vehicle);
            setAvailable(false);
        }
    }

    public boolean checkIfVehicleFits(VehicleType vehicleType){
        return vehicleType== VehicleType.FOUR_WHEELER;
    }
}
