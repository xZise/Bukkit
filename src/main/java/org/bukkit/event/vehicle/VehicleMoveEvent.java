package org.bukkit.event.vehicle;

import org.bukkit.Location;
import org.bukkit.entity.Vehicle;
import org.bukkit.location.DirectionalEntityLocation;

/**
 * Raised when a vehicle moves.
 *
 * @author sk89q
 */
public class VehicleMoveEvent extends VehicleEvent {
    private DirectionalEntityLocation from;
    private DirectionalEntityLocation to;

    public VehicleMoveEvent(Vehicle vehicle, DirectionalEntityLocation from, DirectionalEntityLocation to) {
        super(Type.VEHICLE_MOVE, vehicle);

        this.from = from;
        this.to = to;
    }

    /**
     * Get the previous position.
     *
     * @return
     */
    //TODO: Change from Location to DirectionalEntityLocation
//    public DirectionalEntityLocation getFrom() {
//        return from;
//    }
    public Location getFrom() {
        return new Location(from);
    }

    /**
     * Get the next position.
     *
     * @return
     */
    //TODO: Change from Location to DirectionalEntityLocation
//    public DirectionalEntityLocation getTo() {
//        return to;
//    }
    public Location getTo() {
        return new Location(to);
    }
}
