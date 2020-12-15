package x919;

//字符串常量就是String 的匿名对象 （保存在堆内存中）
public class Str_Equals {
    public static void main(String[] args) {
        String str = "hello"; // 匿名对象设置了 一个名字str
//        String str = null;
//        从  str 可以调用String 的方法equals 说明str 其实就是String的匿名对象
        if ("hello".equals(str)) {
            System.out.println("用户输入的是hello");
        } else {
            System.out.println("用户输入错误");
        }

        if (str.equals("hello")) {  // NullPointerException 空指针异常
            System.out.println("用户输入的是hello");
        } else {
            System.out.println("用户输入错误");
        }


    }
}
