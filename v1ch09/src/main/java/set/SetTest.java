package set;

import java.util.*;

/**
 * This program uses a set to print all unique words in System.in.
 * D:\ALa\Code\StudyJava\src\v1ch09>java set/SetTest < D:\ALa\Code\StudyJava\gutenberg/alice30.txt
 * @author Cay Horstmann
 * @version 1.12 2015-06-21
 */
public class SetTest {
    public static void main(String[] args) {
        var words = new HashSet<String>();
        long totalTime = 0;
        
        try (var in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        
        Iterator<String> iter = words.iterator();
        int MANGETOUTS = 20;
        for (int i = 1; i <= MANGETOUTS && iter.hasNext(); i++) {
            System.out.println(iter.next());
        }
        System.out.println(". . .");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
    }
}
