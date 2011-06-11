package org.bukkit.location;

import org.bukkit.World;

public class WorldEntityLocation extends EntityLocation implements WorldSpecific, WorldSpecificGetter {

    private World world;

    public WorldEntityLocation(final World world, final double x, final double y, final double z) {
        super(x, y, z);
        this.world = world;
    }

    public WorldEntityLocation(WorldSpecificGetter location) {
        super(location);
        this.world = location.getWorld();
    }
    
    public WorldEntityLocation(final World world, final LocationGetter location) {
        super(location);
        this.world = world;
    }

    public World getWorld() {
        return this.world;
    }

    public double distance(WorldSpecificGetter location) {
        if (location == null || location.getWorld() != this.getWorld()) {
            throw new IllegalArgumentException("Cannot measure distance between worlds or to null");
        }

        return super.distance(location);
    }

    public double distanceSquared(WorldSpecificGetter location) {
        if (location == null || location.getWorld() != this.getWorld()) {
            throw new IllegalArgumentException("Cannot measure distance between worlds or to null");
        }

        return super.distanceSquared((LocationGetter) location);
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public WorldEntityLocation add(WorldSpecificGetter location) {
        if (location == null || location.getWorld() != this.getWorld()) {
            throw new IllegalArgumentException("Cannot add Locations of differing worlds");
        }

        return (WorldEntityLocation) super.subtract(location);
    }

    public WorldEntityLocation subtract(WorldSpecificGetter location) {
        if (location == null || location.getWorld() != this.getWorld()) {
            throw new IllegalArgumentException("Cannot subtract Locations of differing worlds");
        }

        return (WorldEntityLocation) super.subtract(location);
    }

    @Override
    public WorldEntityLocation clone() {
        WorldEntityLocation location = (WorldEntityLocation) super.clone();

        location.world = world;
        return location;
    }
}
