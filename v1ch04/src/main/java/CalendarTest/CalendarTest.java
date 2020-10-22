package CalendarTest;

import java.time.*;

/**
 * The type Calendar test.
 *
 * @author Cay Horstmann 这个示例展示了然后使用一个类的接口来完成相当复杂的任务如日历表，而不需要考虑具体实现，只需要使用import导入
 * @version 1.5 2015-05-08
 */
public class CalendarTest {
    public static void main(String[] args) {
        /*
         表示时间点的Date类
         用日历表示法表示日期的LocalDate类
         先获取当前的时间
        */
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        /*
        假如今天4号，today=4,
         4-1=3,
         date.minusDays(3)意思是今天之前3天的日期，即1号
         set to start of month
        */
        date = date.minusDays(today - 1);

        /*
        得到这个月的第一天是星期几
        今天4号，对应是星期日，
        这个月的第一天是星期4，即value=4
        */
        DayOfWeek weekday = date.getDayOfWeek();
        // 1 = Monday, . . . , 7 = Sunday
        int value = weekday.getValue();
        
        
        //打印日历中第一行的缩进，和表头
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }

        /*
        循环条件内设置，只打印当前月份的，到了下个月则循环结束
        因为我们不知道这个月有几天，那就设置date还在当前月份就继续迭代打印
        */
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            //如果打印到当前日期 如4号，则用一个*标记
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            
            //日期加一天，并且当加到了下一个星期1时，自动换行
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
        /*
        循环体结束时，date应该是11月1日，星期日，所以要打印一个换行符结束
        如果正好这天是星期1，之前的循环体最后已经打印过一个换行符，则不需要再次打印一个
        */
        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }
}
