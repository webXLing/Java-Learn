package inner_nm_class;

/*
如果接口的实现类（或者父类的子类），只需使用唯一一次
那么何种情况下 就可以省略该类的定义 而改为使用「匿名内部类」

匿名内部类 定义格式
接口名称 对象名 = new 接口名称(){
    // 覆盖重写所有的方法
}

匿名内部类
注意事项

 */
public class DemoMain {
    public static void main(String[] args) {
//        MyInterface obj = new MyInterfaceImpl();
//        obj.method();

//        匿名内部类
        MyInterface obj1 = new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类");
            }

            @Override
            public void method1() {
                System.out.println("匿名内部类");
            }
        };
        obj1.method();
    }
}
