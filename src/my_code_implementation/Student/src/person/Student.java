package person;

/**
 * 学生管理系统中的学生类
 *
 * @author ZYJ
 */
public class Student extends Person {
    
    
    /**
     * 总成绩
     */
    private final int score;
    
    public Student(String id, String name, int age, String sex, String address, int score) {
        super(id, name, age, sex, address);
        this.score = score;
    }
    
    public int getScore() {
        return score;
    }
    
    
}
