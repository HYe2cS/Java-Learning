package objectAnalyzer;

import java.util.*;

/**
 * This program uses reflection to spy on objects.
 *
 * @author Cay Horstmann
 * @version 1.13 2018-03-16
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args)
            throws ReflectiveOperationException {
        var squares = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
