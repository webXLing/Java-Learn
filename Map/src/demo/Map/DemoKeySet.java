package demo.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
    map 集合的第一种遍历方式  健找值
    1.通过KeySet 将 map 中的 key 存放在 set集合中
    2.然后通过遍历  set集合  通过map.get()方法  来间接的遍历map 集合
 */
public class DemoKeySet {
    public static void main(String[] args) {
        Map<String,Integer> map =new HashMap<>();
        map.put("小红",1);
        map.put("小花",12);
        map.put("小雷",11);

        Set<String> strings = map.keySet();

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(map.get(iterator.next()));

        }

        System.out.println("================下面通过增强for 循环 set集合");

        for (String string : strings) {
            System.out.println(map.get(string));

        }
    }
}


