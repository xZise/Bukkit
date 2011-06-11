package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.location.DirectionalEntityLocation;

/**
 * Stores data for entities standing inside a portal block
 */
public class EntityPortalEnterEvent extends EntityEvent {

    private DirectionalEntityLocation location;

    public EntityPortalEnterEvent(Entity entity, DirectionalEntityLocation location) {
        super(Type.ENTITY_PORTAL_ENTER, entity);
        this.location = location;
    }

    /**
     * Gets the portal block the entity is touching
     * @return The portal block the entity is touching
     */
    //TODO: Change from Location to DirectionalEntityLocation
//  public DirectionalEntityLocation getLocation() {
//      return location;
//  }
  public Location getLocation() {
      return new Location(location);
  }
}