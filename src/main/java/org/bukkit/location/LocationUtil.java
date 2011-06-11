package org.bukkit.location;

public final class LocationUtil {

    public final static LocationGetter ZERO_LOCATION = new LocationGetter() {

        public double lengthSquared() {
            return 0;
        }

        public double length() {
            return 0;
        }

        public double getZ() {
            return 0;
        }

        public double getY() {
            return 0;
        }

        public double getX() {
            return 0;
        }

        public int getBlockZ() {
            return 0;
        }

        public int getBlockY() {
            return 0;
        }

        public int getBlockX() {
            return 0;
        }

        public double distanceSquared(LocationGetter location) {
            return 0;
        }

        public double distance(LocationGetter location) {
            return 0;
        }

        public double dot(LocationGetter other) {
            return 0;
        }

        public LocationGetter getMidpoint(LocationGetter other) {
            if (other == ZERO_LOCATION) {
                return ZERO_LOCATION;
            } else {
                return other.getMidpoint(this);
            }
        }
    };

    private LocationUtil() {
    }

    /**
     * Safely converts a double (location coordinate) to an int (block coordinate)
     *
     * @param loc Precise coordinate
     * @return Block coordinate
     */
    public static int locToBlock(double loc) {
        return (int) Math.floor(loc);
    }

    /**
     * Returns whether the location is within a sphere.
     *
     * @param location Tested location.
     * @param origin The origin of the sphere.
     * @param radius The radius of the sphere.
     * @return whether the location is in the sphere
     */
    public static boolean isInSphere(LocationGetter location, LocationGetter origin, double radius) {
        return (Math.pow(origin.getX() - location.getX(), 2) + Math.pow(origin.getY() - location.getY(), 2) + Math.pow(origin.getZ() - location.getZ(), 2)) <= Math.pow(radius, 2);
    }
    
    /**
     * Returns whether the location is in an axis-aligned bounding box.
     * The minimum and maximum locations given must be truly the minimum and
     * maximum X, Y and Z components.
     *
     * @param location
     * @param min
     * @param max
     * @return whether the location is in the AABB
     */
    public static boolean isInAABB(LocationGetter location, LocationGetter min, LocationGetter max) {
        return location.getX() >= min.getX() && location.getX() <= max.getX() && location.getY() >= min.getY() && location.getY() <= max.getY() && location.getZ() >= min.getZ() && location.getZ() <= max.getZ();
    }
    
    /**
     * Gets the angle between the two locations in radians.
     *
     * @param a First location.
     * @param b Second location.
     * @return angle between a and b in radians.
     */
    public static float angle(LocationGetter a, LocationGetter b) {
        double dot = a.dot(b) / (a.length() * b.length());

        return (float) Math.acos(dot);
    }
    
}
