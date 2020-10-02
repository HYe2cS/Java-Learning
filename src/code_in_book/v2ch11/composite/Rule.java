package composite;

import java.awt.*;

/**
 * This class describes a Porter-Duff rule.
 */
class Rule {
    private final String name;
    private final String porterDuff1;
    private final String porterDuff2;
    
    /**
     * Constructs a Porter-Duff rule.
     *
     * @param n   the rule name
     * @param pd1 the first row of the Porter-Duff square
     * @param pd2 the second row of the Porter-Duff square
     */
    public Rule(String n, String pd1, String pd2) {
        name = n;
        porterDuff1 = pd1;
        porterDuff2 = pd2;
    }
    
    /**
     * Gets an explanation of the behavior of this rule.
     *
     * @return the explanation
     */
    public String getExplanation() {
        var r = new StringBuilder("Source ");
        if ("  ".equals(porterDuff2)) {
            r.append("clears");
        }
        if (" S".equals(porterDuff2)) {
            r.append("overwrites");
        }
        if ("DS".equals(porterDuff2)) {
            r.append("blends with");
        }
        if (" D".equals(porterDuff2)) {
            r.append("alpha modifies");
        }
        if ("D ".equals(porterDuff2)) {
            r.append("alpha complement modifies");
        }
        if ("DD".equals(porterDuff2)) {
            r.append("does not affect");
        }
        r.append(" destination");
        if (" S".equals(porterDuff1)) {
            r.append(" and overwrites empty pixels");
        }
        r.append(".");
        return r.toString();
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    /**
     * Gets the value of this rule in the AlphaComposite class.
     *
     * @return the AlphaComposite constant value, or -1 if there is no matching constant
     */
    public int getValue() {
        try {
            return (Integer) AlphaComposite.class.getField(name).get(null);
        } catch (Exception e) {
            return -1;
        }
    }
}
