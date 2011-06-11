package org.bukkit.event.world;

import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.location.DirectionalEntityLocation;

/**
 * An event that is called when a world's spawn changes. The
 * world's previous spawn location is included.
 *
 * @author willurd
 */
public class SpawnChangeEvent extends WorldEvent {
    private DirectionalEntityLocation previousLocation;

    public SpawnChangeEvent(World world, DirectionalEntityLocation previousLocation) {
        super(Type.SPAWN_CHANGE, world);
        this.previousLocation = previousLocation;
    }

    /**
     * Gets the previous spawn location
     *
     * @return Location that used to be spawn
     */
    // TODO: Change from Location to DirectionalEntityLocation
//  public DirectionalEntityLocation getLocation() {
//      return location;
//  }
    public Location getPreviousLocation() {
        return new Location(this.previousLocation);
    }
}
