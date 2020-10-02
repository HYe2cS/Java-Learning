package abstractClasses;

import java.time.*;

public class Employee extends Person {
    private double salary;
    private final LocalDate hireDay;
    
    public Employee(String name, double salary, int year, int month, int day) {
        //调用超类(抽象类)的构造器,赋值name
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }
    
    public double getSalary() {
        return salary;
    }
    
    public LocalDate getHireDay() {
        return hireDay;
    }
    
    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }
    
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
