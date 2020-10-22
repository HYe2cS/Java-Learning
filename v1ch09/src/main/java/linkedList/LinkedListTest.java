package linkedList;

import java.util.*;

/**
 * This program demonstrates operations on linked lists.
 *
 * @author Cay Horstmann
 * @version 1.12 2018-04-10
 */
public class LinkedListTest {
    public static void main(String[] args) {
        var a = new LinkedList<String>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");
        
        var b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");
        
        /*
         merge the words from b into a
         result
         |ACE |BDFG
         
         A|CE |BDFG
         AB|CE B|DFG
         
         ABC|E B|DFG
         ABCD|E BD|FG
         
         ABCDE| BD|FG
         ABCDEF| BDF|G
        */
    
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();
        
        while (bIter.hasNext()) {
            if (aIter.hasNext()) {
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        
        System.out.println(a);
        
        /*
         remove every second word from b
         result
         |BDFG
         
         B|DFG
         BD|FG
         B|FG
         
         BF|G
         BFG|
         BF|
        */
    
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next(); // skip one element
            if (bIter.hasNext()) {
                bIter.next(); // skip next element
                bIter.remove(); // remove that element
            }
        }
        
        //print: B,F
        System.out.println(b);
        
        // bulk operation: remove all words in b from a
        a.removeAll(b);
        
        System.out.println(a);
    }
}
