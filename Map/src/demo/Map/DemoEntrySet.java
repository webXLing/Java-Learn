package demo.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
    map 集合的第二种遍历方式  使用Entry对象遍历
    1.通过EntrySet 将 map 中的 Entry对象（key value） 存放在 set集合中
    2.然后通过遍历  set集合  通过Entry对象 的getKey()方法  和 getValue() 来间接的遍历map 集合
 */
public class DemoEntrySet {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("小红", 1);
        map.put("小花", 12);
        map.put("小雷", 11);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> nnext = iterator.next();
            System.out.println(nnext.getKey());
            System.out.println(nnext.getValue());
        }

        System.out.println("================下面通过增强for 循环 set集合");

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getValue());
            System.out.println(entry.getKey());
        }
    }
}


