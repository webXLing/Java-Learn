/**
 * 接口 接口之间可以相互继承
 * 一个抽象类只能继承一个抽象的父类 而接口没有这个限制 interface D extends A,B
 * 一个子类只能继承一个抽象类 而去可以实现多个接口
 * Java 中接口 只要是解决单继承局限的问题
 * <p>
 * 接口内部可以定义 抽象内部类 内部类 内部接口
 * <p>
 * 接口在实际开发中三大核心作用
 * 定义不同层之间的操作标准
 * 表示一种操作的能力
 * 表示将服务器端的视图 暴露给客户端
 */
package pkg1008;

interface A {
    public static final String MSG = "nihao";// 全局常量

    public abstract void print(); // 抽象方法
}

interface C {
    String MSG = "nihao";

    public void print();
}

class CC implements C {
    public void print() {
    }
}

interface B {
    public abstract void get();
}

interface D extends A, B { //
    public void funC();
}


class X implements A, B {
    @Override
    public void print() {
        System.out.println("Ade 实现");
    }

    @Override
    public void get() {
        System.out.println("B 的实现");
    }
}

/**
 * 接口内部可以定义 抽象内部类
 */
interface XL {
    public void name();

    abstract class XL1 {
        public abstract void print();
    }

    static interface XL2 {  // static 声明 外部接口
        public void get();
    }
}

class XL2 implements XL, XL.XL2 {// XL.XL2 内部类 继承 接口中的静态接口

    @Override
    public void name() {
        System.out.println("XL name");
    }

    @Override
    public void get() {

    }

    class Y extends XL1 { // 继承接口中的 内部抽象类
        @Override
        public void print() {

        }
    }
}

public class Learn {
    public static void main(String[] args) {
        X x = new X(); // 实例化子类
        x.print();
        A a = x;
        B b = x;
        a.print();
        b.get();

        XL2 xl2 = new XL2();
        xl2.name();
    }
}
