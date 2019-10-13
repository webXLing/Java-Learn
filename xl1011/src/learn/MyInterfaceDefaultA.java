package learn;

public class MyInterfaceDefaultA implements MyInterfaceDefault {
    @Override
    public void method1() {

    }

    @Override
    public void defaultMethod() {
        System.out.println("我覆盖重写了 接口的默认方法");
    }
}
