package myset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
  Set集合 不允许 存储 重复元素


  **Set集合在调用add方法时 会调用元素的hashCode方法和equals方法 来判断元素是否重复
必须 重写hashCode 和equals
 */
public class MySet1 {

    public static void main(String[] args) {
        Set<String> hash = new HashSet<>();
        String str = new String("xl");
        hash.add("a");
        hash.add("xl");
        hash.add("c");

        Set<Person> hash1 = new HashSet<>();

        Person ps1= new Person("小红",1);
        Person ps2= new Person("小红",1);
        hash1.add(ps1);
        hash1.add(ps2);
        System.out.println(hash1);

    }
}
