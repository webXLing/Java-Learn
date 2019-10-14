package canlendar;

import java.util.Calendar;
// 获取默认 时区 的日历
// public static final int YEAR  = 1;
// public static final int MONTH  = 2;
// public static final int DATE  = 5;
// public static final int DAY_OF_MONTH  = 5;
// public static final int HOUR  = 10;
// public static final int MINUTE  = 12;
// public static final int SECOND  = 13;
public class CanlendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        fun1();
    }

    // 根据字段 获取指定值  	get(int field)
    private static void fun1() {
        Calendar calendar = Calendar.getInstance();
//        set(int field, int value)
//        将给定的日历字段设置为给定的值。
        calendar.set(Calendar.MONTH,10);
//        同时设置年月日
        calendar.set(2220,2,19);

        /*
        add(int field, int amount)
        添加或减去指定的时间给定日历领域，基于日历的规则。

         */
        calendar.add(Calendar.YEAR,-1);

        int year = calendar.get(1);
        int month = calendar.get(2);
        System.out.println(year);
        System.out.println(month); // 西方 0-11 月份
        /*
        将日历变为日期
         */
        System.out.println(calendar.getTime());
    }
}
