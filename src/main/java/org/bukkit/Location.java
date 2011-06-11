package org.bukkit;

import org.bukkit.location.DirectionalEntityLocation;
import org.bukkit.location.LocationUtil;
import org.bukkit.util.Vector;

/**
 * Represents a 3-dimensional position in a world
 * @deprecated Use {@link DirectionalEntityLocation}!
 */
public class Location extends DirectionalEntityLocation {

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
