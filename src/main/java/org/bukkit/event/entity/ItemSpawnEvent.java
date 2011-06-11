package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.location.DirectionalEntityLocation;

/**
 * Called when an item is spawned into a world
 */
public class ItemSpawnEvent extends EntityEvent implements Cancellable {

    private DirectionalEntityLocation location;
    private boolean canceled;

    public ItemSpawnEvent(Entity spawnee, DirectionalEntityLocation loc) {
        super(Type.ITEM_SPAWN, spawnee);
        this.location = loc;
    }

    /**
     * Gets the cancellation state of this event. A canceled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @return true if this event is canceled
     */
    public boolean isCancelled() {
        return canceled;
    }

    /**
     * Sets the cancellation state of this event. A canceled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @param cancel true if you wish to cancel this event
     */
    public void setCancelled(boolean cancel) {
        canceled = cancel;
    }

    /**
     * Gets the location at which the item is spawning.
     * @return The location at which the item is spawning
     */
    // TODO: Change from Location to DirectionalEntityLocation
//    public DirectionalEntityLocation getLocation() {
//        return location;
//    }
    public Location getLocation() {
        return new Location(location);
    }
}
