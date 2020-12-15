package demo.Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
HashMap 自定义存储

Map集合保证唯一
    作为key的元素必须重写hashcode 和equals方法来  保证key唯一

 */
public class HashMapSavePerson {
    public static void main(String[] args) {
        show();
        show1();
    }

    /*
key w为 Person
value 为String 可以重复

     */
    private static void show1() {
        HashMap<Person, String> hashMap = new HashMap<>();

        hashMap.put(new Person("xl", 1), "北京1");
        hashMap.put(new Person("xl1", 2), "北京2");
        hashMap.put(new Person("xl3", 3), "北京3");
        hashMap.put(new Person("xl", 1), "北京4");

        Set<Map.Entry<Person, String>> entries = hashMap.entrySet();

        for (Map.Entry<Person, String> entry : entries) {
            System.out.println(entry.getKey() + entry.getValue());
        }

    }

    /*
    key 为String  String 类已经重写了 hashcode 和equals方法
    value Person 可以重复  同名同年龄 视为同一个人
     */
    private static void show() {
        HashMap<String, Person> hashMap = new HashMap<>();

        hashMap.put("北京", new Person("xl", 1));
        hashMap.put("北京1", new Person("x2l", 10));
        hashMap.put("北京2", new Person("xl32", 1));
        hashMap.put("北京", new Person("xl321", 1));

        Set<String> strings = hashMap.keySet();
        for (String string : strings) {
            System.out.println(hashMap.get(string));
        }

        System.out.println(hashMap);

    }
}
