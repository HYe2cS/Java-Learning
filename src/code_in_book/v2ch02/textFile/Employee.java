package textFile;

import java.time.*;

public class Employee {
    private final String name;
    private double salary;
    private final LocalDate hireDay;
    
    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public LocalDate getHireDay() {
        return hireDay;
    }
    
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
    
    @Override
    public String toString() {
        return getClass().getName()
                + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}
