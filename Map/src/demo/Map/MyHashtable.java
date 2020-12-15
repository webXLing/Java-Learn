package demo.Map;

import java.util.HashMap;
import java.util.Hashtable;

/*
 Class Hashtable<K,V>    不能存储null值 null建
  最早期的 双列集合 同步的 单线程 速度慢 但是安全

  HashMap 异步的 多线程 速度慢 可以存储null值 null建
 implements Map<K,V>

 Hashtable 和Vector集合一样 在jdk1.2 之后被更先进的集合取代了（HashMap，ArrayList） 取代了
 Hashtable 的子类 Properties仍活跃
 */
public class MyHashtable {
    public static void main(String[] args) {
        Hashtable<String, String> stringStringHashtable = new Hashtable<>();
        HashMap<String, String> stringStringHashtable1 = new HashMap<>();

        stringStringHashtable1.put(null, null);
        System.out.println(stringStringHashtable1);

    }
}
