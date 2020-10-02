package map;

import java.util.*;

/**
 * This program demonstrates the use of a map with key type String and value type Employee.
 * 这个程序演示了使用键类型String和值类型Employee的映射
 * @author Cay Horstmann
 * @version 1.12 2015-06-21
 */
public class MapTest {
    public static void main(String[] args) {
        var staff = new HashMap<String, Employee>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Harry Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));
        
        // print all entries
        // 打印所有条目
        System.out.println(staff);
        
        // remove an entry
        //remove an entry
        staff.remove("567-24-2546");
        
        // replace an entry
        // 替换条目
        staff.put("456-62-5527", new Employee("Francesca Miller"));
        
        // look up a value
        // 查找值
        System.out.println(staff.get("157-62-7935"));
        
        // iterate through all entries
        // 遍历所有条目
        staff.forEach((k, v) ->
                System.out.println("key=" + k + ", value=" + v));
    }
}
