package Demo.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
java.lang.throwable 类 是java中错误和异常的超类
    异常：编译期异常
        runtimeException 运行期出现的异常
通过try catch 抓取错误


 */
public class Demo {
    public static void main(String[] args) /*throws ParseException*/ { //交给虚拟机处理异常
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        try {
            date = sdf.parse("199909-23");//将字符串格式的 转化为date
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);  // jiang
        System.out.println("后续代码");

        try {
            int[] arr = {1, 3, 3};
            System.out.println(arr[4]); //ArrayIndexOutOfBoundsException
        } catch (Exception e) {
            System.out.println(e);
        }

        int[] arr1 = new int[1024 * 1024 * 1024]; // OutOfMemoryError 超过了jvm分配内存的最大值

    }
}
