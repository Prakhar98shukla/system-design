package parking.lot.parkingspots;

import parking.lot.enums.VehicleType;

public class ParkingSpotFactory {
            public static ParkingSpot createParkingSpot(String spotId, VehicleType vehicleType){
                return switch (vehicleType) {
                    case TWO_WHEELER-> new TwoWheelerSpot(spotId);
                    case FOUR_WHEELER-> new FourWheelerSpot(spotId);
                    default->throw new IllegalArgumentException("Parking lot does not support this type");
                };
            }
}
