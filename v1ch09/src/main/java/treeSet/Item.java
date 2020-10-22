package treeSet;

import java.util.*;

/**
 * An item with a description and a part number.
 */
public class Item implements Comparable<Item> {
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
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }
    
    @Override
    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }
}
