package map;

/**
 * 一个测试用的Employee类
 * @author ZYJ
 */
public class Employee {
    /**
     * 员工姓名
     */
    private final String name;
    /**
     * 工资
     */
    private final double salary;
    
    /**
     * 构造器，实现默认工资为0
     *
     * @param name 员工姓名
     */
    public Employee(String name) {
        this.name = name;
        salary = 0;
    }
    
    /**
     * 重载覆盖一个toString方法
     */
    @Override
    public String toString() {
        return "[name is " + name + ", salary is " + salary + "]";
    }
}
