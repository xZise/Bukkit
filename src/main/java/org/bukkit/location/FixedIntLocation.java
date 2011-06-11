package org.bukkit.location;

public class FixedIntLocation implements LocationGetter {
    
    public final int x;
    public final int y;
    public final int z;
    
    private Double lenSqr;
    private Double len;
    
    public FixedIntLocation(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public FixedIntLocation(LocationGetter location) {
        this.x = location.getBlockX();
        this.y = location.getBlockY();
        this.z = location.getBlockZ();
    }

    public int getBlockX() {
        return this.x;
    }

    public int getBlockY() {
        return this.y;
    }

    public int getBlockZ() {
        return this.z;
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
        int x = (this.x + other.getBlockX()) / 2;
        int y = (this.y + other.getBlockY()) / 2;
        int z = (this.z + other.getBlockZ()) / 2;
        return new FixedIntLocation(x, y, z);
    }

}
