package org.bukkit.location;

import org.bukkit.World;

public class FixedDirectionalEntityLocation extends FixedWorldDoubleLocation implements DirectionalGetter {

    private final float yaw;
    private final float pitch;
    
    public FixedDirectionalEntityLocation(World world, double x, double y, double z) {
        this(world, x, y, z, 0, 0);
    }
    
    public FixedDirectionalEntityLocation(World world, double x, double y, double z, float yaw, float pitch) {
        super(world, x, y, z);
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public FixedDirectionalEntityLocation(World world, LocationGetter location, float yaw, float pitch) {
        super(world, location);
        this.yaw = yaw;
        this.pitch = pitch;
    }
    
    public FixedDirectionalEntityLocation(World world, LocationGetter location) {
        this(world, location, 0, 0);
    }
    
    public FixedDirectionalEntityLocation(WorldSpecificGetter location, float yaw, float pitch) {
        this(location.getWorld(), location, yaw, pitch);
    }
    
    public FixedDirectionalEntityLocation(WorldSpecificGetter location) {
        this(location.getWorld(), location);
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }
    
}
