package date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*

DateFormat 是一个抽象类 所以用他的子类  SimpleDateFormat
年y 月M 日d 时H 分m 秒s
 */
public class Demo01DateFormat {
    public static void main(String[] args) throws ParseException {

        fun3();
    }

    // getTime  2019年 10月 14日 19时 58分 35秒 解析
    private static void fun3() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 d日 H时 m分 s秒");

        Date date = sdf.parse("2019年 12月 30日 4时 32分 1秒 ");
        System.out.println(date);  // 2019年 10月 14日 19时 58分 35秒
    }

    //   2019年 10月 14日 19时 58分 35秒 格式化
    private static void fun2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 d日 H时 m分 s秒");

        Date date = new Date();
        String str = sdf.format(date);
        System.out.println(str);  // 2019年 10月 14日 19时 58分 35秒
    }

}
