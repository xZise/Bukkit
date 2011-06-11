package org.bukkit;

import org.bukkit.location.DirectionalEntityLocation;
import org.bukkit.location.EntityLocation;
import org.bukkit.location.LocationGetter;
import org.bukkit.location.LocationUtil;
import org.bukkit.location.WorldEntityLocation;
import org.bukkit.util.Vector;

/**
 * Represents a 3-dimensional position in a world
 * @deprecated Use {@link DirectionalEntityLocation}!
 */
public class Location extends DirectionalEntityLocation {

    private final DirectionalEntityLocation ref;
    
    /**
     * Constructs a new Location with the given coordinates
     *
     * @param world The world in which this location resides
     * @param x The x-coordinate of this new location
     * @param y The y-coordinate of this new location
     * @param z The z-coordinate of this new location
     */
    public Location(final World world, final double x, final double y, final double z) {
        super(world, x, y, z);
        this.ref = null;
    }

    /**
     * Constructs a new Location with the given coordinates and direction
     *
     * @param world The world in which this location resides
     * @param x The x-coordinate of this new location
     * @param y The y-coordinate of this new location
     * @param z The z-coordinate of this new location
     * @param yaw The absolute rotation on the x-plane, in degrees
     * @param pitch The absolute rotation on the y-plane, in degrees
     */
    public Location(final World world, final double x, final double y, final double z, final float yaw, final float pitch) {
        super(world, x, y, z, yaw, pitch);
        this.ref = null;
    }

    public Location(DirectionalEntityLocation from) {
        super(from.getWorld(), from.getX(), from.getY(), from.getZ(), from.getYaw(), from.getPitch());
        this.ref = from;
    }
    
    // Change reference values!
    public void setYaw(float yaw) {
        super.setYaw(yaw);
        if (this.ref != null)
            this.ref.setYaw(yaw);
    }

    public void setPitch(float pitch) {
        super.setPitch(pitch);
        if (this.ref != null)
            this.ref.setPitch(pitch);
    }
    
    public void setWorld(World world) {
        super.setWorld(world);
        if (this.ref != null)
            this.ref.setWorld(world);
    }
    
    public EntityLocation add(Double x, Double y, Double z) {
        super.add(x, y, z);
        if (this.ref != null)
            this.ref.add(x, y, z);
        return this;
    }
    
    public EntityLocation midpoint(LocationGetter other) {
        super.midpoint(other);
        if (this.ref != null)
            this.ref.midpoint(other);
        return this;
    }
    
    public EntityLocation normalize() {
        super.normalize();
        if (this.ref != null)
            this.ref.normalize();
        return this;
    }
    
    public EntityLocation crossProduct(LocationGetter o) {
        super.crossProduct(o);
        if (this.ref != null)
            this.ref.normalize();
        return this;
    }
    
    public EntityLocation copy(LocationGetter vec) {
        super.copy(vec);
        if (this.ref != null)
            this.ref.copy(vec);
        return this;
    }
    
    public EntityLocation divide(LocationGetter location) {
        super.divide(location);
        if (this.ref != null)
            this.ref.divide(location);
        return this;
    }
    
    public EntityLocation multiply(LocationGetter vec) {
        super.multiply(vec);
        if (this.ref != null)
            this.ref.multiply(vec);
        return this;
    }
    
    public EntityLocation multiply(Double factor) {
        super.multiply(factor);
        if (this.ref != null)
            this.ref.multiply(factor);
        return this;
    }
    
    public WorldEntityLocation zero() {
        super.zero();
        if (this.ref != null)
            this.ref.zero();
        return this;
    }

    /**
     * Constructs a new {@link Vector} based on this Location
     *
     * @return New Vector containing the coordinates represented by this Location
     * @deprecated Use this instance or <code>new EntityLocation(this)</code>. <code>EntityLocation</code> is the replacement for <code>Vector</code>.
     */
    @Deprecated
    public Vector toVector() {
        return new Vector(getX(), getY(), getZ());
    }

    @Override
    public Location clone() {
        return (Location) super.clone();
    }

    /**
     * Safely converts a double (location coordinate) to an int (block coordinate)
     *
     * @param loc Precise coordinate
     * @return Block coordinate
     * @deprecated Use {@code LocationUtil#locToBlock(double)}
     */
    @Deprecated
    public static int locToBlock(double loc) {
        return LocationUtil.locToBlock(loc);
    }
}
