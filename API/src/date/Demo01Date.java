package date;

import java.util.Date;

/*
java.util.Date 表示日期和时间的类
1970年1月1日 00：00：00 (英国格林威治)

东八区 中国
 */
public class Demo01Date {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());//获取当前系统时间到19700101 00：00经历了多少毫秒

        fun();
        fun1();
        fun3();
    }

    // getTime
    private static void fun3() {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);

    }


    // Date类带参构造 long date
    private static void fun1() {
        Date date = new Date(0L);
        System.out.println(date);//Thu Jan 01 08:00:00 CST 1970  英国是0毫秒 中国处于东8区

        date = new Date(1571053341352L);
        System.out.println(date);
    }

    // 空参
    private static void fun() {
        Date date = new Date();
        System.out.println(date);//Mon Oct 14 19:39:35 CST 2019  说明Date类重写了toString 方法
    }
}
