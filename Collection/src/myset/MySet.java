package myset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
  java.util.set extends Collection 接口
  1.不允许 重复内容
  2.没有索引 也不能用普通的for 遍历

  java.util.HashSet集合 implement Set 接口

  特点
  1.不允许 重复内容
  2.没有索引 也不能用普通的for 遍历
  3.是一个无序集合 存入 取出顺序可能不同
  4.底层是一个哈希表结构（查询速度非常的块）

 */
public class MySet {

    public static void main(String[] args) {
        Set<String> hash = new HashSet<>();
        hash.add("a");
        hash.add("b");
        hash.add("c");
        hash.add("d");
        hash.add("a");

        System.out.println(hash);

        Iterator<String> iterator = hash.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String s : hash) {
            System.out.println(s);
        }

    }
}
