package demo1;

import java.util.ArrayList;
import java.util.Collection;

/*
forEach jdk1.5之后的特性
public interface Collection<E> extends Iterable<E>  继承了Iterable

实现这个接口允许一个对象成为“每个循环”语句的目标。看到 For-each Loop

 格式：
 for(集合/数组的数据类型 变量名：集合名/数组名){
    sout（变量名）
 }
 */
public class Foreach {
    public static void main(String[] args) {
        fun();
        fun1();
    }

    private static void fun1() {
        Collection<String> coll =  new ArrayList<>();
        coll.add("sad");
        for (String i:coll ) {
            System.out.println(i);
        }
    }

    private static void fun() {
        int []arr = {1,3,43,43};
         for (int i:arr ) {
             System.out.println(i);
        }
    }
}
