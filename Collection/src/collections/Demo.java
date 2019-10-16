package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/*
java.util.Collections  集合工具类

帮助 lsit 集合 添加多个元素


注意 sort 方法的适用前提
    被集合存储的元素，必须实现 Comparable接口 重写 conpareto 定义排序接口

    Compare接口 规则
    自己（this） - 参数  升序
    反之降序

        Comparable接口 和  Comparator 区别
         Comparable接口 要自己实现Comparable接口 并重写 重写 conpareto 定义排序接口
         Comparator 找第三方
         o1-o2 是升序
         o2-o1 是降序
    sort 2
    static <T> void	sort(List<T> list, Comparator<? super T> c)
根据指定的比较器引起的顺序对指定的列表进行排序。
 */

public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> lsit = new ArrayList<>();
        lsit.add(10);

        Collections.addAll(lsit,1,3);
        Collections.shuffle(lsit);// 打乱
        Collections.sort(lsit, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        }); // 默认升序

        System.out.println(lsit);


        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("小红",1));
        list.add(new Person("小红2",10));
        list.add(new Person("小红3",9));

        Collections.sort(list);
//        System.out.println(list);
        for (Person person : list) {
            System.out.println(person.getAge());
        }

    }
}
