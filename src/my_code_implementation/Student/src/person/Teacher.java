package person;

import java.time.LocalDate;

/**
 * @author ZYJ
 */
public class Teacher extends Person {
    /**
     * 工作日
     */
    private final LocalDate hireDay;
    /**
     * 工资
     */
    private final double salary;
    
    public Teacher(String id, String name, int age, String sex, String address, LocalDate hireDay, double salary) {
        super(id, name, age, sex, address);
        this.hireDay = hireDay;
        this.salary = salary;
    }
}
