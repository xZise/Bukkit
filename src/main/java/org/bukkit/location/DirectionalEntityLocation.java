package org.bukkit.location;

import org.bukkit.World;

public class DirectionalEntityLocation extends WorldEntityLocation implements Directional {

    private float yaw;
    private float pitch;
    
    public DirectionalEntityLocation(final World world, final double x, final double y, final double z) {
        this(world, x, y, z, 0, 0);
    }
    
    public DirectionalEntityLocation(final World world, final LocationGetter location) {
        this(world, location, 0, 0);
    }
    
    public DirectionalEntityLocation(final World world, final LocationGetter location, final float yaw, final float pitch) {
        super(world, location);
        this.yaw = yaw;
        this.pitch = pitch;
    }
    
    public DirectionalEntityLocation(final World world, final double x, final double y, final double z, final float yaw, final float pitch) {
        super(world, x, y, z);
        this.yaw = yaw;
        this.pitch = pitch;
    }
    
    public DirectionalEntityLocation(WorldSpecificGetter location) {
        super(location);
    }
    
    public DirectionalEntityLocation(WorldSpecificGetter location, DirectionalGetter direction) {
        this(location);
        this.yaw = direction.getYaw();
        this.pitch = direction.getPitch();
    }
    
    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }
    
    @Override
    public DirectionalEntityLocation clone() {
        DirectionalEntityLocation location = (DirectionalEntityLocation) super.clone();

        location.yaw = this.yaw;
        location.pitch = this.pitch;
        return location;
    }
    
    /**
     * Gets a Vector pointing in the direction that this Location is facing
     *
     * @return Vector
     */
    public LocationGetter getDirection() {

        double rotX = Math.toRadians(this.getYaw());
        double rotY = Math.toRadians(this.getPitch());

        double h = Math.cos(rotY);

        double y = -Math.sin(rotY);
        double x = -h * Math.sin(rotX);
        double z = h * Math.cos(rotX);

        return new FixedDoubleLocation(x, y, z);
    }
    
    public WorldEntityLocation zero() {
        super.zero();
        this.yaw = 0;
        this.pitch = 0;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DirectionalEntityLocation)) {
            return false;
        }
        final DirectionalEntityLocation other = (DirectionalEntityLocation) obj;

        if (this.getWorld() != other.getWorld() && (this.getWorld() == null || !this.getWorld().equals(other.getWorld()))) {
            return false;
        }
        if (Double.doubleToLongBits(this.getX()) != Double.doubleToLongBits(other.getX())) {
            return false;
        }
        if (Double.doubleToLongBits(this.getY()) != Double.doubleToLongBits(other.getY())) {
            return false;
        }
        if (Double.doubleToLongBits(this.getZ()) != Double.doubleToLongBits(other.getZ())) {
            return false;
        }
        if (Float.floatToIntBits(this.getPitch()) != Float.floatToIntBits(other.getPitch())) {
            return false;
        }
        if (Float.floatToIntBits(this.getYaw()) != Float.floatToIntBits(other.getYaw())) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;

        hash = 19 * hash + (this.getWorld() != null ? this.getWorld().hashCode() : 0);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.getX()) ^ (Double.doubleToLongBits(this.getX()) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.getY()) ^ (Double.doubleToLongBits(this.getY()) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.getZ()) ^ (Double.doubleToLongBits(this.getZ()) >>> 32));
        hash = 19 * hash + Float.floatToIntBits(this.getPitch());
        hash = 19 * hash + Float.floatToIntBits(this.getYaw());
        return hash;
    }

    @Override
    public String toString() {
        return "DirectionalEntityLocation{" + "world=" + getWorld() + "x=" + getX() + "y=" + getY() + "z=" + getZ() + "pitch=" + getPitch() + "yaw=" + getYaw() + '}';
    }
}
