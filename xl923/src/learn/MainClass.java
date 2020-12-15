package learn;

class Book {
    static String msg = "nihao";

    public Book() {
        System.out.println("构造方法 Book");
    }

    { // 构造块
        System.out.println("代码块");
    }

    static { // 静态块  优先于 主方法执行
        msg = msg.substring(0, 2);
        System.out.println(msg);
    }
}

// 内部类
class Outer {
    private String outermsg = "outermsg";
    static String ms = "??";

    class Inner {  // private  这内部类 只能在 outer 内 调用
        private String innerMsg = "inerMsg";

        public void print() {
            System.out.println(Outer.this.outermsg);
        }
    }

    static class Inn1 { // 相当于 一个外部类
        public Inn1() {
            System.out.println("Inn1");
            System.out.println(ms);
//            System.out.println(Outer.this); // 你会发现这里会报错  原因就是 这个内部静态类 不需要外部类实例化后就可以 实例化所以 那么也就不发访问外部类的实例this
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
        Book book = new Book(); // 我们发现代码里面的代码先执行
        Outer outer = new Outer();
        Outer.Inner in = new Outer().new Inner();
        in.print();
        Outer.Inn1 inn1 = new Outer.Inn1();
    }
}
