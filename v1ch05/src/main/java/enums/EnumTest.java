package enums;

import java.util.*;

enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    /**
     * 缩写 abbreviation
     */
    private final String abbreviation;
    
    public String getAbbreviation() {
        return abbreviation;
    }
    
    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}

/**
 * This program demonstrates enumerated types.
 *
 * @author Cay Horstmann
 * @version 1.0 2004-05-24
 */
public class EnumTest {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
        String input = in.next().toUpperCase();
        /*
         Enum.valueOf(Size.class, input)
         返回具有指定名称的指定枚举类型的枚举常量。名称必须与用于声明此类型中枚举常量的标识符完全匹配。（不允许使用多余的空白字符。）
         请注意，对于特定的枚举类型T，可以使用该枚举上隐式声明的public static T valueOf（String）方法来代替此方法来从名称映射到相应的枚举常量。
         可以通过调用枚举类型的隐式public static T[]values（）方法来获取枚举类型的所有常量。
        */
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job--you paid attention to the _.");
        }
    }
}
