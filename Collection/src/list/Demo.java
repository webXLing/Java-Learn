package list;

import java.util.ArrayList;
import java.util.Iterator;

/*
    java.util.list extends Collection 接口
    1.有序的集合
    2.有索引
    3.允许存储 重复元素

    add(int index, E element)
将指定的元素插入此列表中的指定位置（可选操作）
    注意 索引越界
ArrayList 底层是一个数组结构 增删的时候是 开辟一个新的数组
查询快 增删慢  异步的
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("xl");
        list.add("xl");
        list.add("x43l");
        list.add("x43l");

        list.add(1, "77");
        list.remove(2); // 删除
        list.set(3, "jintian");// 替换

//        list集合遍历 有三种方式
//        1.for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

//        使用迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //增强for
        for (String s : list) {
            System.out.println(s);
        }

        list.get(10); // IndexOutOfBoundsException 索引越界异常 集合
//        ArrayIndexOutOfBoundsException 数组索引越界异常
//                StringIndexOutOfBoundsException 字符串索引越界异常
        System.out.println(list);
        //重写了toString方法
    }
}
