package org.bukkit.util;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.location.DirectionalEntityLocation;
import org.bukkit.location.EntityLocation;
import org.bukkit.location.LocationUtil;

/**
 * Represents a mutable vector. Because the components of Vectors are mutable,
 * storing Vectors long term may be dangerous if passing code modifies the
 * Vector later. If you want to keep around a Vector, it may be wise to call
 * <code>clone()</code> in order to get a copy.
 *
 * @author sk89q
 * @deprecated Use {@link EntityLocation} instead
 */
@Deprecated
public class Vector extends EntityLocation {
    private static final long serialVersionUID = -2657651106777219169L;

    private static Random random = new Random();

    /**
     * Threshold for fuzzy equals().
     */
    private static final double epsilon = 0.000001;

    /**
     * Construct the vector with all components as 0.
     */
    public Vector() {
        super(0, 0, 0);
    }

    /**
     * Construct the vector with provided integer components.
     *
     * @param x
     * @param y
     * @param z
     */
    // obsolete! Already covered by Vector(double, double, double);
    public Vector(int x, int y, int z) {
        super(x, y, z);
    }

    /**
     * Construct the vector with provided double components.
     *
     * @param x
     * @param y
     * @param z
     */
    public Vector(double x, double y, double z) {
        super(x, y, z);
    }

    /**
     * Construct the vector with provided float components.
     *
     * @param x
     * @param y
     * @param z
     */
    // obsolete! Already covered by Vector(double, double, double);
    public Vector(float x, float y, float z) {
        super(x, y, z);
    }

    /**
     * Adds the vector by another.
     *
     * @param vec
     * @return the same vector
     */
    public Vector add(Vector vec) {
        return (Vector) super.add(vec);
    }

    /**
     * Subtracts the vector by another.
     *
     * @param vec
     * @return the same vector
     */
    public Vector subtract(Vector vec) {
        return (Vector) super.subtract(vec);
    }

    /**
     * Multiplies the vector by another.
     *
     * @param vec
     * @return the same vector
     */
    public Vector multiply(Vector vec) {
        return (Vector) super.multiply(vec);
    }

    /**
     * Divides the vector by another.
     *
     * @param vec
     * @return the same vector
     */
    public Vector divide(Vector vec) {
        return (Vector) super.divide(vec);
    }

    /**
     * Copies another vector
     *
     * @param vec
     * @return the same vector
     */
    public Vector copy(Vector vec) {
        return (Vector) super.copy(vec);
    }

    /**
     * Gets the angle between this vector and another in radians.
     *
     * @param other
     * @return angle in radians
     * @deprecated Use {@link LocationUtil#angle(org.bukkit.location.LocationGetter, org.bukkit.location.LocationGetter)} instead.
     */
    @Deprecated
    public float angle(Vector other) {
        return LocationUtil.angle(this, other);
    }

    /**
     * Sets this vector to the midpoint between this vector and another.
     *
     * @param other
     * @return this same vector (now a midpoint)
     */
    public Vector midpoint(Vector other) {
        return (Vector) super.midpoint(other);
    }

    /**
     * Gets a new midpoint vector between this vector and another.
     *
     * @param other
     * @return a new midpoint vector
     */
    public Vector getMidpoint(Vector other) {
        return (Vector) super.getMidpoint(other);
    }

    /**
     * Performs scalar multiplication, multiplying all components with a scalar.
     *
     * @param m
     * @return the same vector
     */
    public Vector multiply(double m) {
        return (Vector) super.multiply(m);
    }

    /**
     * Calculates the dot product of this vector with another. The dot product
     * is defined as x1*x2+y1*y2+z1*z2. The returned value is a scalar.
     *
     * @param other
     * @return dot product
     */
    public double dot(Vector other) {
        return super.dot(other);
    }

    /**
     * Calculates the cross product of this vector with another. The cross
     * product is defined as:
     *
     * x = y1 * z2 - y2 * z1<br/>
     * y = z1 * x2 - z2 * x1<br/>
     * z = x1 * y2 - x2 * y1
     *
     * @param o
     * @return the same vector
     */
    public Vector crossProduct(Vector o) {
        return (Vector) super.crossProduct(o);
    }

    /**
     * Converts this vector to a unit vector (a vector with length of 1).
     *
     * @return the same vector
     */
    public Vector normalize() {
        return (Vector) super.normalize();
    }

    /**
     * Zero this vector's components.
     *
     * @return the same vector
     */
    public Vector zero() {
        return (Vector) super.zero();
    }

    /**
     * Returns whether this vector is in an axis-aligned bounding box.
     * The minimum and maximum vectors given must be truly the minimum and
     * maximum X, Y and Z components.
     *
     * @param min
     * @param max
     * @return whether this vector is in the AABB
     * @deprecated Use {@link LocationUtil#isInAABB(org.bukkit.location.LocationGetter, org.bukkit.location.LocationGetter, org.bukkit.location.LocationGetter)}
     */
    @Deprecated
    public boolean isInAABB(Vector min, Vector max) {
        return LocationUtil.isInAABB(this, min, max);
    }

    /**
     * Returns whether this vector is within a sphere.
     *
     * @param origin
     * @param radius
     * @return whether this vector is in the sphere
     * @deprecated Use {@link LocationUtil#isInSphere(org.bukkit.location.LocationGetter, org.bukkit.location.LocationGetter, double)}
     */
    @Deprecated
    public boolean isInSphere(Vector origin, double radius) {
        return LocationUtil.isInSphere(this, origin, radius);
    }
    
    /**
     * Set the X component.
     *
     * @param x
     * @return x
     */
    //TODO: Use in new classes?
    public Vector setX(double x) {
        super.setX(x);
        return this;
    }

    /**
     * Set the Y component.
     *
     * @param y
     * @return y
     */
    //TODO: Use in new classes?
    public Vector setY(double y) {
        super.setY(y);
        return this;
    }

    /**
     * Set the Z component.
     *
     * @param z
     * @return z
     */
    //TODO: Use in new classes?
    public Vector setZ(double z) {
        super.setZ(z);
        return this;
    }

    /**
     * Get a new vector.
     *
     * @return vector
     */
    @Override
    public Vector clone() {
        return (Vector) super.clone();
    }

    /**
     * Gets a Location version of this vector with yaw and pitch being 0.
     *
     * @param world
     * @return the location
     * @deprecated Use direct instance or <code>new DirectionalEntityLocation(world, this)</code>. <code>DirectionalEntityLocation</code> is the replacement for <code>Location</code>.
     */
    @Deprecated
    public Location toLocation(World world) {
        return new Location(world, this.getX(), this.getY(), this.getZ());
    }

    /**
     * Gets a Location version of this vector.
     *
     * @param world
     * @return the location
     * @deprecated Use direct instance or <code>new DirectionalEntityLocation(world, this, yaw, pitch)</code>. <code>DirectionalEntityLocation</code> is the replacement for <code>Location</code>.
     */
    @Deprecated
    public Location toLocation(World world, float yaw, float pitch) {
        return new Location(world, this.getX(), this.getY(), this.getZ(), yaw, pitch);
    }

    /**
     * Get the block vector of this vector.
     *
     * @return
     * @deprecated Use direct instance or <code>new BlockLocation(this)</code>. <code>BlockLocation</code> is the replacement for <code>BlockVector</code>.
     */
    public BlockVector toBlockVector() {
        return new BlockVector(this.getBlockX(), this.getBlockY(), this.getBlockZ());
    }

    /**
     * Get the threshold used for equals().
     *
     * @return
     */
    public static double getEpsilon() {
        return epsilon;
    }

    /**
     * Gets the minimum components of two vectors.
     *
     * @param v1
     * @param v2
     * @return minimum
     */
    public static Vector getMinimum(Vector v1, Vector v2) {
        return new Vector(Math.min(v1.getX(), v2.getX()), Math.min(v1.getY(), v2.getY()), Math.min(v1.getZ(), v2.getZ()));
    }

    /**
     * Gets the maximum components of two vectors.
     *
     * @param v1
     * @param v2
     * @return maximum
     */
    public static Vector getMaximum(Vector v1, Vector v2) {
        return new Vector(Math.max(v1.getX(), v2.getX()), Math.max(v1.getY(), v2.getY()), Math.max(v1.getZ(), v2.getZ()));
    }

    /**
     * Gets a random vector with components having a random value between
     * 0 and 1.
     *
     * @return
     */
    public static Vector getRandom() {
        return new Vector(random.nextDouble(), random.nextDouble(), random.nextDouble());
    }
}
