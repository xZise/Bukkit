package org.bukkit.location;

public interface Directional extends DirectionalGetter {

    void setYaw(float yaw);
    void setPitch(float pitch);
    
    LocationGetter getDirection();
    
}
