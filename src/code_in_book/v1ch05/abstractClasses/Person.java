package abstractClasses;

/**
 * This program demonstrates abstract classes.
 * 这个程序演示抽象类。
 *
 * @author Cay Horstmann
 * @version 1.01 2004-02-21
 */
public abstract class Person {
    /**
     * 获取描述
     *
     * @return 学生或者雇员等的描述
     */
    public abstract String getDescription();
    
    /**
     * name是赋值一次后不可更改的，修饰为final
     */
    private final String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
