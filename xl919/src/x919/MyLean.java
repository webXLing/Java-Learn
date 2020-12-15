package x919;

// String 类的两种实例化方式
public class MyLean {
    public static void main(String[] args) {

        /*
         * == 与equals()的区别
         * */
        String str = "nihao"; // 直接赋值  开辟一块内存空间
        String str1 = new String("nihao");  //   利用构造方法实例化  开辟一块内存空间

        String str2 = str1; // 指针


        System.out.println(str == str1); // false
        System.out.println(str == str2); // false
        System.out.println(str2 == str1);// false

        //  上面的例子说明了  java 中的 == 是内存地址相同 而不是内容的相同
//        equals():是String 提供的一个方法 专门用与 字符串内容的比较
        System.out.println(str.equals(str1));
        System.out.println(str.equals(str2));
        System.out.println(str1.equals(str2));
        System.out.println("--------------------------");


        String mystr1 = "xl"; //  匿名对象设置了 一个名字str 开辟一块堆内存 并且开辟了一块栈内存指向了该堆内存
        String mystr2 = "xl";
        String mystr3 = "xl";
        System.out.println(mystr1 == mystr2);
        System.out.println(mystr1 == mystr3);
        System.out.println(mystr2 == mystr3);

        System.out.println("--------------------------");

        /*共享设计模式
         直接赋值 实例化
         JVM底层实际上 有一个对象池 （不一定只保存String对象）
        当直接赋值一个String类 对象时，会将这个匿名对象入池保存 ，
        如果后续又有直接赋值的方式 并且设置了相同的内容时，将不再开辟新的堆内存空间，而是用已有的对象进行引用的分配
        */

        /*
        构造函数 实例化
        首先 "xl"是一个匿名对象 会开辟一个堆内存 xl（1）
                然后new 也会开辟一个新的堆内存 xl（2） 让栈内存指向这个用new 出来的堆内存空间
                所以 xl(1) 就是一个垃圾空间
                并且用 new 出来的 堆内存空间不会入池  如需手动入池 可以用 .intern()
        */
        String mystr4 = new String("xl");

        String mystr5 = new String("xl").intern(); // 手工入池
        String mydtr6 = new String("xl");
        String mystr7 = "xl";

        System.out.println(mystr4 == mystr5);
        System.out.println(mydtr6 == mystr4);
        System.out.println(mydtr6 == mystr5);
        System.out.println(mystr7 == mystr5);
    }
}
