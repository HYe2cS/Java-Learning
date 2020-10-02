package set;

import java.util.*;

import bytecodeAnnotations.*;

/**
 * An item with a description and a part number.
 *
 * @author Cay Horstmann
 * @version 1.01 2012-01-26
 */
public class Item {
    private final String description;
    private final int partNumber;
    
    /**
     * Constructs an item.
     *
     * @param aDescription the item's description
     * @param aPartNumber  the item's part number
     */
    public Item(String aDescription, int aPartNumber) {
        description = aDescription;
        partNumber = aPartNumber;
    }
    
    /**
     * Gets the description of this item.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return "[description=" + description + ", partNumber=" + partNumber + "]";
    }
    
    @Override
    @LogEntry(logger = "com.horstmann")
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
        var other = (Item) otherObject;
        return Objects.equals(description, other.description) && partNumber == other.partNumber;
    }
    
    @Override
    @LogEntry(logger = "com.horstmann")
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }
}
