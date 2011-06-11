package org.bukkit.location;

import org.bukkit.World;

public class FixedWorldIntLocation extends FixedIntLocation implements WorldSpecificGetter {

    private final World world;

    public FixedWorldIntLocation(World world, int x, int y, int z) {
        super(x, y, z);
        this.world = world;
    }

    public FixedWorldIntLocation(World world, LocationGetter location) {
        super(location);
        this.world = world;
    }

    public FixedWorldIntLocation(WorldSpecificGetter location) {
        this(location.getWorld(), location);
    }

    public World getWorld() {
        return this.world;
    }

}
