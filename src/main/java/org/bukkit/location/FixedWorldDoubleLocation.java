package org.bukkit.location;

import org.bukkit.World;

public class FixedWorldDoubleLocation extends FixedDoubleLocation implements WorldSpecificGetter {

    private final World world;
    
    public FixedWorldDoubleLocation(World world, double x, double y, double z) {
        super(x, y, z);
        this.world = world;
    }

    public FixedWorldDoubleLocation(World world, LocationGetter location) {
        super(location);
        this.world = world;
    }
    
    public FixedWorldDoubleLocation(WorldSpecificGetter location) {
        this(location.getWorld(), location);
    }
    
    public World getWorld() {
        return this.world;
    }

}
