package demo.gener;
/*
Ceshi
 */
public class Gener {
    public static void main(String[] args) {

        // 在实现接口是就已经决定了 泛型的类型
        GenerInterfaceImpl1 impl1 = new GenerInterfaceImpl1();
        impl1.fun("xl");


        // 在产生 实例对象是决定 泛型的类型
        GenerInterfaceImpl2I<Integer> impl2 = new GenerInterfaceImpl2I<>();
        impl2.fun(1);

    }
}
