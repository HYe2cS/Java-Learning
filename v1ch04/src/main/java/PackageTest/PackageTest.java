package PackageTest;

import com.horstmann.corejava.*;
import EmployeeTest.Employee;
// the Employee class is defined in that package

import static java.lang.System.*;

/**
 * This program demonstrates the use of packages.
 *
 * @author Cay Horstmann
 * @version 1.11 2004-02-19
 */
public class PackageTest {
    public static void main(String[] args) {
        /*
         because of the import statement, we don't have to use
         com.horstmann.corejava.Employee here
         因为import语句，我们不必使用com.horstmann.corejava.Employee 做前缀
        */
        var harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        
        //增加salary
        harry.raiseSalary(5);
        
        // because of the static import statement, we don't have to use System.out here
        out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
    }
}
