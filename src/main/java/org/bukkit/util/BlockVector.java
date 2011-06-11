package org.bukkit.util;

import org.bukkit.location.BlockLocation;
import org.bukkit.location.LocationUtil;

/**
 * A vector with a hash function that floors the X, Y, Z components, a la
 * BlockVector in WorldEdit. BlockVectors can be used in hash sets and
 * hash maps. Be aware that BlockVectors are mutable, but it is important
 * that BlockVectors are never changed once put into a hash set or hash map.
 *
 * @author sk89q
 * @deprecated Use {@link BlockLocation} instead
 */
@Deprecated
public class BlockVector extends BlockLocation {

    /**
     * Construct the vector with all components as 0.
     */
    public BlockVector() {
        super(0, 0, 0);
    }

    /**
     * Construct the vector with another vector.
     */
    public BlockVector(Vector vec) {
        super(vec);
    }

    /**
     * Construct the vector with provided integer components.
     *
     * @param x
     * @param y
     * @param z
     */
    public BlockVector(int x, int y, int z) {
        super(x, y, z);
    }

    /**
     * Construct the vector with provided double components.
     *
     * @param x
     * @param y
     * @param z
     */
    public BlockVector(double x, double y, double z) {
        super(LocationUtil.locToBlock(x), LocationUtil.locToBlock(y), LocationUtil.locToBlock(z));
    }

    /**
     * Checks if another object is equivalent.
     *
     * @param obj
     * @return whether the other object is equivalent
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BlockVector)) {
            return false;
        }
        BlockVector other = (BlockVector) obj;

        return other.getBlockX() == this.getBlockX() && other.getBlockY() == this.getBlockY() && other.getBlockZ() == this.getBlockZ();

    }

    /**
     * Returns a hash code for this vector.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return (Integer.valueOf(this.getBlockX()).hashCode() >> 13) ^ (Integer.valueOf(this.getBlockY()).hashCode() >> 7) ^ Integer.valueOf(this.getBlockZ()).hashCode();
    }

    /**
     * Get a new block vector.
     *
     * @return vector
     */
    @Override
    public BlockVector clone() {
        return (BlockVector) super.clone();
    }
}
