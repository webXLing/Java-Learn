package demo1;

import java.util.ArrayList;
import java.util.Collection;

/*
boolean	add(E e)
确保此集合包含指定的元素（可选操作）

boolean	remove(Object o)
从这个集合中移除指定元素的一个实例，如果它是存在的（可选操作）。

boolean contains(Object o)
返回 true如果集合包含指定元素。更正式地说，返回 true当且仅当这个集合包含至少一个元素 e这样 (o==null ? e==null : o.equals(e))。

boolean isEmpty()
返回 true如果集合不包含任何元素。

int size()
返回此集合中的元素的数目。如果这个集合包含多 Integer.MAX_VALUE元素，返回 Integer.MAX_VALUE。

Object[] toArray()
返回包含此集合中所有元素的数组。如果这个集合对命令它的迭代器返回的元素有什么样的保证，则该方法必须返回相同的顺序中的元素。

void clear()
从这个集合中移除所有的元素（可选操作）。该方法返回后将清空集合。
 */
public class Demo {
    public static void main(String[] args) {
        Collection<String> co = new ArrayList<>(); // 多态
        System.out.println(co);
        /*
        add
         */
        co.add("nihao");
        co.add("xl");

        /*
        remove
         */
        co.remove("xl"); //true
        co.remove("xl1");// false

        /*
        contains
         */
        System.out.println(co.contains("nihao"));

        System.out.println(co); // [nihao, xl]


    }
}
