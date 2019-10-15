package demo.gener;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        fun();
        fun1();
    }
    /*
    使用 泛型  编译期（写代码）就能发现问题
     */
    private static void fun1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("dk");
//        list.add(1); // 报错 需要传入Sring
        list.add("x2el");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println(iterator.next().length());
        }
    }

    /*
    集合不写泛型
    好处：默认类型为Object类型 可以存储任意的数据类型
    坏处：不安全
     */
    private static void fun() {
        ArrayList list = new ArrayList();

        list.add("xl");
        list.add(1);

        Iterator iterator = list.iterator();

        while (iterator.hasNext()){
//            每一项 是Object 类型
            //想使用String 特有的方法 获取length
//            需要向下转型
            Object next = iterator.next();
            if(next instanceof String){ // 不安全
                String str = (String) next;
                System.out.println("length"+str.length());
            }
            System.out.println(next);
        }
    }
}

