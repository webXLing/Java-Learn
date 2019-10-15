package list;
/*
java.util.LinkedLidt implement List接口
LinkedList 是一个链表结构
增删快 查询慢

使用LinkedList集合的特有方法 不要使用多态
 */

import java.util.LinkedList;

public class MyLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();

        list.add("xl");
        list.add("A");
        list.add("B");
        list.add("C");

        list.addFirst("WWW");
        list.push("push");  //往头部添加
        list.addLast("d");
//        list.clear();//清空
        list.remove(2);
        list.pop();

        if(!list.isEmpty()){
            System.out.println(list.getFirst()); // NoSuchElementException 没有元素
            System.out.println(list.getLast());
        }

        System.out.println(list);
    }
}
