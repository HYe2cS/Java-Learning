/**
 * @author Cay Horstmann
 * @version 1.10 1999-11-13
 */

public class Employee {
    private final String name;
    private final double salary;
    
    public native void raiseSalary(double byPercent);
    
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }
    
    public void print() {
        System.out.println(name + " " + salary);
    }
    
    static {
        System.loadLibrary("Employee");
    }
}
