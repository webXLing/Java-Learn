package x919;

//    java string 内容不能改变
public class StrResult {
    public static void main(String[] args) {
        String str = "xl"; // 开辟栈内存 存放str  开辟堆内存 存放xl
        str = str + "jiayou"; // 先开辟新堆内存 存放jiayou  然后再 开辟一个堆内存 存放计算结果 xljiayou  str指向xljiayou 这样之前的堆内存将变为垃圾
        str += "!!";
        System.out.println(str);

    }
   /*
    . 字符串内容的比较 使用equals  == 是比较内存地址
    . 字符串内容一旦申明就不能改变 string 类对象内容的改变 是一开引用关系的变更实现的 并且会产生垃圾
    . 共享设计模式
         直接赋值 实例化
        JVM底层实际上 有一个对象池 （不一定只保存String对象）
        当直接赋值一个String类 对象时，会将这个匿名对象入池保存 ，
        如果后续又有直接赋值的方式 并且设置了相同的内容时，将不再开辟新的堆内存空间，而是用已有的对象进行引用的分配

        构造函数 实例化
        首先 "xl"是一个匿名对象 会开辟一个堆内存 xl（1）
                然后new 也会开辟一个新的堆内存 xl（2） 让栈内存指向这个用new 出来的堆内存空间
                所以 xl(1) 就是一个垃圾空间
                并且用 new 出来的 堆内存空间不会入池  如需手动入池 可以用 .intern()
   */
}
