package map;

// 处理日期类 localdate

import java.util.*;

/**
 * This program demonstrates the use of a map with key type String and value type Employee.
 * 这个程序演示了使用键类型String和值类型Employee的映射
 * 首先将键、值对添加到映射中。然后从映射中删除一个键。
 * 同时与之关联的值也会删除。
 * 接下来，修改与某一个键关联的值，并调用get方法查找一个值
 * 最后迭代处理元素集
 *
 * @author ZYJ
 * @version 1.00 2020-10-17
 */
public class MapTest {
    
    // 数据集
//        staff.put("144-25-5464", new Employee("Amy Lee"));
//        staff.put("567-24-2546", new Employee("Harry Hacker"));
//        staff.put("157-62-7935", new Employee("Gary Cooper"));
//        staff.put("456-62-5527", new Employee("Francesca Cruz"));
    
    public static void main(String[] args) {
        // 新建一个数据集，使用HashMap存储
        // 首先将键、值对添加到映射中。
//        var[3] staff = new HashMap[3]; wrong
        var staff = new HashMap<String, Employee>();
        // 匿名类
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Harry Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));
        
        // print
        // 已经覆盖了toString方法
        System.out.println(staff);
        
        
        // 然后然后从映射中删除一个键。
        staff.remove("567-24-2546");
        System.out.println(staff);
        
        // 接下来，修改与某一个键关联的值，并调用get方法查找一个值
        // replace
        staff.put("456-62-5527", new Employee("Francesca Miller"));
        System.out.println(staff.get("456-62-5527"));
        
        // 最后迭代处理元素集
        // iterate
        staff.forEach((k, v) -> {
            System.out.println("change！");
            System.out.println("key=" + k + ",value=" + v);
        });
        
        // test lambda
        staff.forEach((k, v) ->
                
                System.out.println("key=" + k + ",value=" + v)
        );
    }
}

