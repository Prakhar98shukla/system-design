package parking.lot.parkingspots;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Ticker;

import parking.lot.enums.VehicleType;
import parking.lot.gates.*;
import parking.lot.vehicles.Vehicles;
public class ParkingSpotManager {
    private static ParkingSpotManager instance;
    private Map<String,ParkingSpot> parkingSpots;
    private Map<Integer,Ticket> tickets ;
    private EntryGate entryGate;
    private ExitGate exitGate;
    
    private ParkingSpotManager(){
        this.parkingSpots=new HashMap<>();
        this.tickets=new HashMap<>();     
    }
    private static synchronized ParkingSpotManager getInstance(){
        if(instance==null){
            return new ParkingSpotManager();
        }
        return instance;
    }

    public Ticket parkVehicle(Vehicles vehicle){
        for(ParkingSpot spot: parkingSpots.values()){
            if(spot.isAvailable()&& spot.checkIfVehicleFits((VehicleType) vehicle.getVehicleType())){
                Ticket ticket = generateParkingTicket(spot,vehicle);
                return ticket;
            }
        }
        return null;
    }

    private Ticket generateParkingTicket(ParkingSpot spot, Vehicles vehicle) {
        if(isFull(vehicle.getVehicleType())){
            throw new RuntimeException("[-] NO available parking spot for Vehicle");
        }
        Ticket ticket=new Ticket(spot,vehicle);
        tickets.put(ticket.getTicketNo(), ticket);
        return ticket;

    }
    private boolean isFull(VehicleType vehicleType) {
        return parkingSpots.values().stream().noneMatch(spot->spot.checkIfVehicleFits(vehicleType));
    }

    
    public void unParkVehicle(String spotId){
        ParkingSpot spot=parkingSpots.get(spotId);
        if(spot!=null) spot.removeVehicleFromParkingSpot();
        System.out.println("[+] Available Parking Spots: "+this.getAvailableSpotsCount());
    }
   
    private int getAvailableSpotsCount() {
        return (int)parkingSpots.values().stream().filter(ParkingSpot::isAvailable).count();
    }
    public void addParkingSpots(ParkingSpot spot) {
             parkingSpots.put(spot.getSpotId(), spot);
    }
    public void removeParkingSpots(ParkingSpot spot) {
             parkingSpots.remove(spot.getSpotId());
    }
    
   
    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }
    public ExitGate getExitGate() {
        return exitGate;
    }

}
