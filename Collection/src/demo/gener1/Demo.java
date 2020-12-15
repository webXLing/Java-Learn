package demo.gener1;

import java.util.ArrayList;
import java.util.Iterator;

/*
泛型的 通配符
？：代表任意类型
不能创建对象是使用
只能作为方法的参数使用
 */
public class Demo {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("xl");

        fun(list1);
        fun(list2);

//        ArrayList<?> list3 = new ArrayList<?>();/


    }

    //    定义所有类型的ArrayList 集合
    // 该方法  不知道 传给的ArrayList 的类型 就可以用泛型的通配符
    // 泛型没有 继承关系的
    public static void fun(ArrayList<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next(); // 取出来的 对象一定是Object 类型
            System.out.println(next);
        }
    }
}

