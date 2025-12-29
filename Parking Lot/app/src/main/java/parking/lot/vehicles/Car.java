package parking.lot.vehicles;
import parking.lot.enums.VehicleType;

public class Car extends Vehicles {

    public Car(String VehicleNo, VehicleType vehicleType) {
        super(VehicleNo, vehicleType.FOUR_WHEELER);
    }

    
}
