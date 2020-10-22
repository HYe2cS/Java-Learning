package pair2;

import java.time.*;

/**
 * @author Cay Horstmann
 * @version 1.02 2015-06-21
 */
public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                // G. Hopper
                LocalDate.of(1906, 12, 9),
                // A. Lovelace
                LocalDate.of(1815, 12, 10),
                // J. von Neumann
                LocalDate.of(1903, 12, 3),
                // K. Zuse
                LocalDate.of(1910, 6, 22),
        };
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}

class ArrayAlg {
    /**
     * Gets the minimum and maximum of an array of objects of type T.
     *
     * @param a an array of objects of type T
     * @return a pair with the min and max values, or null if a is null or empty
     */
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        // 传参T[] a
        // <T extends Comparable>
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        // return Pair<T>
        return new Pair<>(min, max);
    }
}
