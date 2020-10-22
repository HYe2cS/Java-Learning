package ConstructorTest;

import java.util.*;

/**
 * This program demonstrates object construction.
 * 这个程序演示对象构造
 *
 * @author Cay Horstmann
 * @version 1.02 2018-04-10
 */
public class ConstructorTest {
    public static void main(String[] args) {
        /*
         fill the staff array with three Employee objects
         用三个Employee对象填充staff数组
        */
        var staff = new Employee[3];
        
        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();
        
        /*
         print out information about all Employee objects
         打印所有员工对象的信息
        */
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
            
        }
    }
}

class Employee {
    /**
     * 静态字段
     */
    private static int nextId;
    
    /**
     * 声明为final的字段只能被赋值一次
     */
    private final int id;
    
    /**
     * instance field initialization
     * 实例字段初始化
     */
    private String name = "";
    
    /**
     * 普通形式的字段
     */
    private double salary;
    
    /*
     static initialization block
     静态初始化块
    */
    static {
        var generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);
    }
    
    /*
     object initialization block
     对象初始化块
    */ {
        id = nextId;
        nextId++;
    }
    
    /**
     * three overloaded constructors
     * 三个重载的构造函数
     */
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }
    
    public Employee(double s) {
        // calls the Employee(String, double) constructor
        // nextId在这个Test中是Random的，
        // 本test中使用了java.util.Random public Random()
        this("Employee #" + nextId, s);
    }
    
    /**
     * the default constructor
     */
    public Employee() {
        /*
         name initialized to ""--see above
         salary not explicitly set--initialized to 0
         id initialized in initialization block
         
         名称已初始化为“”--请参阅上面的
         salary未显式设置--初始化为0
         初始化块中初始化的id
        */
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public int getId() {
        return id;
    }
}
