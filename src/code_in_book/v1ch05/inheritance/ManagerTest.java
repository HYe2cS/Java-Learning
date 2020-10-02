package inheritance;

/**
 * This program demonstrates inheritance.
 *
 * @author Cay Horstmann
 * @version 1.21 2004-02-21
 */
public class ManagerTest {
    public static void main(String[] args) {
        // construct a Manager object
        var boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        
        var staff = new Employee[3];
        
        // fill the staff array with Manager and Employee objects
        
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
        
        // print out information about all Employee objects
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
        //staff[0].setBonus(5000);
        boss.setBonus(5000);
        
        // Test 多态
        Employee e;
        e = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        e = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());


        /*
            Test 子类引用的数组转换成超类引用的数组
            Java中子类数组的引用可以转换为超类数组的引用，而不需要采用强制类型转换。
            但是managers和staff1引用的是同一个堆上的对象
            即如果试图存储一个Employee类型的引用就会引发ArrayStoreException异常
            具体如下
        */
        /*
        //创建一个引用managers，它指向堆上的对象数组Manager[]
        Manager[] managers = new Manager[10];

        //让另外一个对象引用staff1来指向managers，
        //这样Java中子类数组的引用可以转换为超类数组的引用
        Employee[] staff1 = managers;//OK

        //测试赋值操作，注意到编译器自动阻止了这个操作，并报出ArrayStoreException异常
        //即如果试图存储一个Employee类型的引用就会引发ArrayStoreException异常
        staff1[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);

         */


/*
    我们再尝试分别对managers[0]和staff1[0]分别调用setBonus方法
    注意到managers[0].setBonus(1000);可行
    而staff1[0].setBonus(1000)不可行;
    因为实际上managers和staff1引用的是同一个堆上的对象

 */
        /*
        Manager[] managers = new Manager[10];
        Employee[] staff1 = managers;//OK

        managers[0].setBonus(1000);
        System.out.println("name=" + managers[0].getName() );

        staff1[0].setBonus(1000);
        System.out.println("name=" + staff1[0].getName() );

         */
        
        
    }
    
}
