package retire;

import java.awt.*;

/**
 * These are the Chinese non-string resources for the retirement calculator.
 *
 * @author Cay Horstmann
 * @version 1.21 2001-08-27
 */
public class RetireResources_zh extends java.util.ListResourceBundle {
    private static final Object[][] contents = {
            // BEGIN LOCALIZE
            {"colorPre", Color.red}, {"colorGain", Color.blue}, {"colorLoss", Color.yellow}
            // END LOCALIZE
    };
    
    @Override
    public Object[][] getContents() {
        return contents;
    }
}
