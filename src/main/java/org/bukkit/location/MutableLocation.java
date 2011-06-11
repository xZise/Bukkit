package org.bukkit.location;

public interface MutableLocation<T, B> extends Cloneable {

    void setX(B x);
    void setY(B y);
    void setZ(B z);

    T add(B x, B y, B z);
    T add(LocationGetter location);
    T subtract(B x, B y, B z);
    T subtract(LocationGetter location);
    T multiply(B factor);
    T multiply(LocationGetter location);
    T divide(LocationGetter location);
    
    T copy(LocationGetter location);
    T zero();
    T normalize();
    T crossProduct(LocationGetter location);
    T midpoint(LocationGetter location);
    
}
