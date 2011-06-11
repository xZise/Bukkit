package org.bukkit.location;

import org.bukkit.World;

public interface WorldSpecificGetter extends LocationGetter {

    World getWorld();
    
}
