package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.util.Util;

/**
 * Called when a human entity's food level changes
 */
public class FoodLevelChangeEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private int level;

    public FoodLevelChangeEvent(final Entity what, final int level) {
        super(what);
        this.setFoodLevel(level);
    }

    /**
     * Gets the resultant food level that the entity involved in this event should be set to.
     * <br /><br />
     * Where 20 is a full food bar and 0 is an empty one.
     *
     * @return The resultant food level
     */
    public int getFoodLevel() {
        return level;
    }

    /**
     * Sets the resultant food level that the entity involved in this event should be set to
     *
     * @param level the resultant food level that the entity involved in this event should be set to
     */
    public void setFoodLevel(int level) {
        this.level = Util.between(level, 0, 20);
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
