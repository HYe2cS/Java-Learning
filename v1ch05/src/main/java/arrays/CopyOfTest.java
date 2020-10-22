package arrays;

import java.lang.reflect.*;
import java.util.*;

/**
 * This program demonstrates the use of reflection for manipulating arrays.
 * 反射
 *
 * @author Cay Horstmann
 * @version 1.2 2012-05-04
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));
        
        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));
        
        System.out.println("The following call will generate an exception.");
        b = (String[]) badCopyOf(b, 10);
    }
    
    /**
     * This method attempts to grow an array by allocating a new array and copying all elements.
     * 此方法尝试通过分配新数组并复制所有元素来扩展数组
     *
     * @param a         the array to grow
     * @param newLength the new length
     * @return a larger array that contains all elements of a. However, the returned
     * array has type Object[], not the same type as a
     */
    public static Object[] badCopyOf(Object[] a, int newLength) // not useful
    {
        var newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }
    
    /**
     * This method grows an array by allocating a new array of the same type and
     * copying all elements.
     * 此方法通过分配相同类型的新数组并复制所有元素来扩大数组。
     * 参数: a–要增长的阵列。它可以是对象数组或基元类型数组
     * 返回: 包含a的所有元素的较大数组。
     *
     * @param a the array to grow. This can be an object array or a primitive
     *          type array
     * @return a larger array that contains all elements of a.
     */
    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if (!cl.isArray()) {
            return null;
        }
        /*
        元素类型/组件类型
        获取组件类型(即记住每个元素的类型)
        Java数组会记住每个元素的类型，在new一个数组时，使用到的元素类型
        返回表示数组的组件类型的类。如果该类不表示数组类，则该方法返回null。 返回: 如果该类是数组，则表示该类的组件类型的类
        */
        /*
        为什么getLength是Array类的方法，而getComponentType却是Class类的方法？
        反射方法的分布的确有些古怪，可能是设计者在设计类库时遗留的历史问题。
         */
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        //利用反射编写泛型数组
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}
