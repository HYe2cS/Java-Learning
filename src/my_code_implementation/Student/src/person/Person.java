package person;
/**
 * 共同超类Person
 *
 * @author ZYJ
 */
public class Person {
    /**
     * 学号或者工号
     */
    private final String id;
    private final String name;
    private final int age;
    private final String sex;
    private final String address;
    
    public Person(String id, String name, int age, String sex, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }
    
    
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }
}
