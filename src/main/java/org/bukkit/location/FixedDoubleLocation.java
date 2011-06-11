package org.bukkit.location;

public class FixedDoubleLocation implements LocationGetter {

    public final double x;
    public final double y;
    public final double z;
    
    private Double lenSqr;
    private Double len;
    
    public FixedDoubleLocation(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public FixedDoubleLocation(LocationGetter location) {
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
    }

    public int getBlockX() {
        return LocationUtil.locToBlock(this.x);
    }

    public int getBlockY() {
        return LocationUtil.locToBlock(this.y);
    }

    public int getBlockZ() {
        return LocationUtil.locToBlock(this.z);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public double lengthSquared() {
        if (this.lenSqr == null) {
            this.lenSqr = Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2);
        }
        return this.lenSqr;
    }

    public double length() {
        if (this.len == null) {
            this.len = Math.sqrt(this.lengthSquared());
        }
        return this.len;
    }

    public double distance(LocationGetter location) {
        return Math.sqrt(this.distanceSquared(location));
    }

    public double distanceSquared(LocationGetter location) {
        return Math.pow(this.x - location.getX(), 2) + Math.pow(this.y - location.getY(), 2) + Math.pow(this.z - location.getZ(), 2);
    }

    public double dot(LocationGetter other) {
        return this.x * other.getX() + this.y * other.getY() + this.z * other.getZ();
    }

    public LocationGetter getMidpoint(LocationGetter other) {
        double x = (this.x + other.getX()) / 2;
        double y = (this.y + other.getY()) / 2;
        double z = (this.z + other.getZ()) / 2;
        return new FixedDoubleLocation(x, y, z);
    }


}
