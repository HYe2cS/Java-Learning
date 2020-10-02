package jaas;

import java.security.*;
import java.util.*;

/**
 * A principal with a named value (such as "role=HR" or "username=harry").
 */
public class SimplePrincipal implements Principal {
    private final String descr;
    private final String value;
    
    /**
     * Constructs a SimplePrincipal to hold a description and a value.
     *
     * @param descr the description
     * @param value the associated value
     */
    public SimplePrincipal(String descr, String value) {
        this.descr = descr;
        this.value = value;
    }
    
    /**
     * Returns the role name of this principal.
     *
     * @return the role name
     */
    @Override
    public String getName() {
        return descr + "=" + value;
    }
    
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        SimplePrincipal other = (SimplePrincipal) otherObject;
        return Objects.equals(getName(), other.getName());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
