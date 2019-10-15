package myset;


/*
哈希值  是一个十进制的整数 有系统随机给处（就是对象 的逻辑地址值  不失实际的物理地址）

哈希表
jdk1.8 前 哈希表 = 数组+链表

jdk1.8后
 哈希表 = 数组+链表
哈希表 = 数组+红黑树（增加 查询速度）

总结一下
1.现将 获取元素的哈希值  通过哈希值 分类到数组中去
2.相同哈希值得元素 通过链表排序
3.如果链表超过8位 那么就变为红黑树 这样增加查询的速度
 */
public class MyHash {
    public static void main(String[] args) {
        /*
        String类的hashcode  重写了Object类的hashcode方法
         */
    }
}
