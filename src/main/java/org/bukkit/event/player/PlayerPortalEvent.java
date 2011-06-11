package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.location.DirectionalEntityLocation;
import org.bukkit.block.Block;

/**
 * Called when a player completes the portaling process by standing in a portal
 */
public class PlayerPortalEvent extends PlayerTeleportEvent {
    private boolean useTravelAgent = true;
    public PlayerPortalEvent(Player player, DirectionalEntityLocation from, DirectionalEntityLocation to) {
        super(Type.PLAYER_PORTAL, player, from, to);
    }

    public void useTravelAgent(boolean useTravelAgent){
        this.useTravelAgent = useTravelAgent;
    }
    public boolean useTravelAgent(){
        return useTravelAgent;
    }
}
