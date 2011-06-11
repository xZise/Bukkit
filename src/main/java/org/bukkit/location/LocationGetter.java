package org.bukkit.location;

public interface LocationGetter {

    int getBlockX();
    int getBlockY();
    int getBlockZ();

    double getX();
    double getY();
    double getZ();

    /*
     * This value is a int, if the location is int based (r = x² + y² + z² where
     * x, y, z ∈ integer → r ∈ integer), but could be overflow
     */
    double lengthSquared();
    double length();

    double distance(LocationGetter location);
    double distanceSquared(LocationGetter location);
    
    double dot(LocationGetter other);
    LocationGetter getMidpoint(LocationGetter other);
}
