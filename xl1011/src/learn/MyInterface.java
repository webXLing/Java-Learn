package learn;
/*
接口不能直接使用 必须要有一个实现类

*实现类 必须要覆盖重写 接口中的所有抽象方法
*注意事项 ：如果实现类 它没有全部覆写 接口中的抽象方法 那么它自己必须是抽象类

*接口的默认方法可以被实现类直接调用
*接口的默认方法 也可以被实现类 覆写

接口中的 static 方法 必须要通过接口名.方法名的形式调用
 */
public class MyInterface {
    public static void main(String[] args) {
        DemoImpl impl = new DemoImpl();
        impl.fun1();

        MyInterfaceDefaultA myinerfacea = new MyInterfaceDefaultA();
        myinerfacea.method1();
        myinerfacea.defaultMethod();

        MyInterfaceDefault.staticMethod();
    }
}
