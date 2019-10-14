package stringbuilder;

/*
java.lang.StringBuilder

tringBuilder()
构造一个没有字符的字符串生成器，并构造了16个字符的初始容量。

StringBuilder(String str)
构造一个初始化为指定字符串的内容的字符串生成器。

append

String StringBuilder 相互转化
String => StringBuilder toString
StringBuilder => String toString

 */

public class Demo {
    public static void main(String[] args) {
        StringBuilder str1 = new StringBuilder();
        System.out.println(str1);

        StringBuilder str2 = new StringBuilder("nihao");
        System.out.println(str2);

        str2.append("a").append(1);
        System.out.println(str2);
        //StringBuilder = > String
        System.out.println(str2.toString());
    }
}
