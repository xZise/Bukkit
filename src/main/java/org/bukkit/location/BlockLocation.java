package org.bukkit.location;

public class BlockLocation implements MutableLocation<BlockLocation, Integer>, LocationGetter {

    private int x;
    private int y;
    private int z;
    
    public BlockLocation(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public BlockLocation(LocationGetter location) {
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
        return Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2);
    }

    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    public double distance(LocationGetter location) {
        return Math.sqrt(this.distanceSquared(location));
    }

    public double distanceSquared(LocationGetter location) {
        return Math.pow(this.x - location.getX(), 2) + Math.pow(this.y - location.getY(), 2) + Math.pow(this.z - location.getZ(), 2);
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public BlockLocation add(Integer x, Integer y, Integer z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public BlockLocation add(LocationGetter loc) {
        return this.add(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
    }

    public BlockLocation subtract(Integer x, Integer y, Integer z) {
        return this.add(-x, -y, -z);
    }

    public BlockLocation subtract(LocationGetter loc) {
        return this.add(-loc.getBlockX(), -loc.getBlockY(), -loc.getBlockZ());
    }

    public BlockLocation multiply(Integer factor) {
        this.x *= factor;
        this.y *= factor;
        this.z *= factor;
        return this;
    }

    public BlockLocation zero() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        return this;
    }

    public double dot(LocationGetter other) {
        return this.x * other.getX() + this.y * other.getY() + this.z * other.getZ();
    }

    public LocationGetter getMidpoint(LocationGetter other) {
        int x = (this.x + other.getBlockX()) / 2;
        int y = (this.y + other.getBlockY()) / 2;
        int z = (this.z + other.getBlockZ()) / 2;
        return new BlockLocation(x, y, z);
    }

    public BlockLocation multiply(LocationGetter location) {
        this.x *= location.getX();
        this.y *= location.getY();
        this.z *= location.getZ();
        return this;
    }

    public BlockLocation divide(LocationGetter location) {
        this.x /= location.getX();
        this.y /= location.getY();
        this.z /= location.getZ();
        return this;
    }

    public BlockLocation copy(LocationGetter location) {
        this.x = location.getBlockX();
        this.y = location.getBlockY();
        this.z = location.getBlockZ();
        return this;
    }

    //TODO: Very inaccurate!
    public BlockLocation normalize() {
        double length = length();

        this.x /= length;
        this.y /= length;
        this.z /= length;

        return this;
    }

    public BlockLocation crossProduct(LocationGetter o) {
        int newX = this.y * o.getBlockZ() - o.getBlockY() * this.z;
        int newY = this.z * o.getBlockX() - o.getBlockZ() * this.x;
        int newZ = this.x * o.getBlockY() - o.getBlockX() * this.y;

        this.x = newX;
        this.y = newY;
        this.z = newZ;
        return this;
    }

    public BlockLocation midpoint(LocationGetter other) {
        return this.copy(this.getMidpoint(other));
    }

    @Override
    public BlockLocation clone() {
        try {
            BlockLocation location = (BlockLocation) super.clone();

            location.x = x;
            location.y = y;
            location.z = z;
            return location;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
