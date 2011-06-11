package org.bukkit.event.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.location.DirectionalEntityLocation;

public class PlayerRespawnEvent extends PlayerEvent {
    private DirectionalEntityLocation respawnLocation;

    public PlayerRespawnEvent(Player respawnPlayer, DirectionalEntityLocation respawnLocation) {
        super(Type.PLAYER_RESPAWN, respawnPlayer);
        this.respawnLocation = respawnLocation;
    }

    /**
     * Gets the current respawn location
     *
     * @return Location current respawn location
     */
    // TODO: Change from Location to DirectionalEntityLocation
//  public DirectionalEntityLocation getLocation() {
//      return location;
//  }
    public Location getRespawnLocation() {
        return new Location(this.respawnLocation);
    }

    /**
     * Sets the new respawn location
     *
     * @param respawnLocation new location for the respawn
     */
    public void setRespawnLocation(DirectionalEntityLocation respawnLocation) {
        this.respawnLocation = respawnLocation;
    }
}
