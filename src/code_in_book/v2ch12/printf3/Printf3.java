import java.io.*;

/**
 * @author Cay Horstmann
 * @version 1.10 1997-07-01
 */
class Printf3 {
    public static native void fprint(PrintWriter out, String format, double x);
    
    static {
        System.loadLibrary("Printf3");
    }
}
