package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.location.DirectionalEntityLocation;

/**
 * Holds information for player teleport events
 */
public class PlayerTeleportEvent extends PlayerMoveEvent {
    public PlayerTeleportEvent(Player player, DirectionalEntityLocation from, DirectionalEntityLocation to) {
        super(Type.PLAYER_TELEPORT, player, from, to);
    }
    public PlayerTeleportEvent(final Event.Type type, Player player, DirectionalEntityLocation from, DirectionalEntityLocation to) {
        super(type, player, from, to);
    }
}
