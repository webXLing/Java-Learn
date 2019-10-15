package myset;

import java.util.HashSet;
import java.util.LinkedHashSet;

/*
 java.util.LinkedHashSet集合 extends HashSet 集合
 底层 是一个哈希表（数组+链表/红黑树）+链表 多了一条链表 （记录元素的存储顺序）保证元素有序
 */
public class MyLinkedHashSet {
    public static void main(String[] args) {
        HashSet<String> hash = new HashSet<>();
        hash.add("www");
        hash.add("abc");
        hash.add("xl");
        hash.add("xl");

        System.out.println(hash);// 无序 不允许重复


        LinkedHashSet<String> hash1 = new LinkedHashSet<>();
        hash1.add("www");
        hash1.add("abc");
        hash1.add("xl");
        hash1.add("xl");

        System.out.println(hash1);// 有序 不允许重复
    }
}
