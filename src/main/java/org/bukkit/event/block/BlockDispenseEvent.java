package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.location.EntityLocation;
import org.bukkit.location.LocationGetter;
import org.bukkit.util.Vector;

/**
 * Event called on dispense of an item from a block.
 *
 * @author sk89q
 */
public class BlockDispenseEvent extends BlockEvent implements Cancellable {

    private boolean cancelled = false;
    private ItemStack item;
    private LocationGetter velocity;

    public BlockDispenseEvent(Block block, ItemStack dispensed, LocationGetter velocity) {
        super(Type.BLOCK_DISPENSE, block);
        this.item = dispensed;
        this.velocity = velocity;
    }

    /**
     * Get the item that is being dispensed. Modifying the returned item
     * will have no effect.
     *
     * @return
     */
    public ItemStack getItem() {
        return item.clone();
    }

    /**
     * Set the item being dispensed.
     *
     * @param item
     */
    public void setItem(ItemStack item) {
        this.item = item;
    }

    /**
     * Gets the velocity. Modifying the returned Vector will not
     * change the velocity.
     *
     * @return
     */
    //TODO: Change from Vector to LocationGetter
//    public LocationGetter getVelocity() {
//        return velocity.clone();
//    }
    public Vector getVelocity() {
        return new Vector(velocity);
    }

    /**
     * Set the velocity.
     *
     * @param vel
     */
    public void setVelocity(LocationGetter vel) {
        velocity = vel;
    }

    /**
     * Check to see if the event was cancelled.
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Prevent dispensing.
     */
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
