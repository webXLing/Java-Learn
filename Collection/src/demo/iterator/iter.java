package demo.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
java.util.Iterator 对集合进行遍历

boolean hasNext()
返回 true如果迭代具有更多的元素。（换句话说，如果返回 true next()会返回一个元素而不是抛出一个例外。）

Iterator迭代器 是一个接口  获取实现类的方式比较特殊 Collection接口中有个方法iterator 获取迭代器

迭代器的使用
1.使用集合中的方法iterator（）获取迭代器实现类对象 使用Iterator 接收（多态 ）
 */
public class iter {
    public static void main(String[] args) {
//        创建一个集合对象
        Collection<String> coll = new ArrayList<>();
        coll.add("A");
        coll.add("B");
        coll.add("C ");

//        Iterator<E> 也是有泛型的 跟着集合走
        Iterator<String> iterator = coll.iterator(); // 多态  获取迭代器的实现类对象 ，并将指针（索引）指向集合-1的索引位置


        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
