package demo.Map;

import java.util.HashMap;
import java.util.Map;

/*
 Map 集合 是 双列集合 一个元素包含 两个值 K V
 Collection 集合 单列集合

 Class HashMap<K,V>  implements Map<k,v> 接口

 HashMap 是一个 无序的集合
 LinkedHashMap extends HashMap  底层是 哈希表+链表 有序的 多了一层链表
 */
public class Demo {
    public static void main(String[] args) {
        show();
    }

    /*
    V	put(K key, V value)
        将指定的值与该映射中的指定键相关联（可选操作）。
    返回的是之前的value

    V	remove(Object key)
如果存在（从可选的操作），从该地图中删除一个键的映射。

V get(Object key)
返回到指定键所映射的值，或null如果此映射包含该键的映射。


boolean	containsKey(Object key)
如果此映射包含指定键的映射，则返回 true 。
     */
    private static void show() {
        Map<String, String> map = new HashMap();
        String str1 = map.put("徐", "jiayou");
        System.out.println(str1); // 返回的是之前的value


        String str2 = map.put("徐", "jiayou1");
//        System.out.println(str2); //
        String str3 = map.put("徐", "jiayou1");
//        System.out.println(str3); //

        map.put("徐类", "jiayou1");
//        map.remove("徐");


        System.out.println(map.get("徐类"));
        System.out.println(map.containsKey("徐类"));
        System.out.println(map);

    }
}
