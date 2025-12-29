package parking.lot.vehicles;

import parking.lot.enums.VehicleType;
import parking.lot.gates.Ticket;

public abstract class Vehicles {
    private final String vehicleNo;
    private VehicleType vehicleType;
    private Ticket ticket;

    public Vehicles(String vehicleNo, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

   

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

}
