package demo.gener1;

import java.util.ArrayList;
import java.util.Collection;

/*
泛型 上限限定 ？ extends E  使用的泛型只能是E类型的子类/本身
泛型 下限限定 ？ super E  使用的泛型只能是E类型的父类/本身
 */
public class Demo1 {
    public static void main(String[] args) {
        Collection<Integer> co1 = new ArrayList<>();
        Collection<String> co2 = new ArrayList<>();
        Collection<Number> co3 = new ArrayList<>();
        Collection<Object> co4 = new ArrayList<>();

//        Integer extends Number extends Object

        fun1(co1);
//        fun1(co2); // baocuo
        fun1(co3);
//        fun1(co4); // 报错


//        fun2(co1); // 报错
//        fun2(co2); // baocuo
        fun2(co3);
        fun2(co4);
    }
//    泛型 上限限定 ？ extends E  使用的泛型只能是E类型的子类/本身

    private static void fun1(Collection<? extends Number> coll) {
    }

    //泛型 下限限定 ？ super E  使用的泛型只能是E类型的父类/本身
    private static void fun2(Collection<? super Number> coll) {
    }


}
