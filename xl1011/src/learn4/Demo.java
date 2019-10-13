package learn4;
/*
多态的好处 为了规范
多态 =>父类引用指向 子类对象
左父 右子
格式
父类名称 对象名 = new 子类名称()
或者
接口名称 对象名 = new 实现类名称()

** obj.method() 成员方法  看的是这个对象 new的是谁  就优先调用谁的方法  方法是可以覆写的
口诀：
成员方法：编译看左边 运行看右边
成员变量：编译看左边 运行还看左边



而成员变量 是不能覆写的
所以zi.num  看的是


** 访问成员变的两种方式：
1.直接通过对象名访问成员变量 ：看等号左边是谁，优先用谁，没有则向上查找
2.间接通过成员方法访问成员变量：该方法属于谁 就用谁 没有就向上查找


 */

public class Demo {
    public static void main(String[] args) {
        // 多态的写法
        // 左侧父类的引用 指向右侧子类对象
        Fu zi = new Zi();
        Zi zi1 = new Zi();
//        zi.funzi(); // 错误写法 父类方法中没有funzi方法
        zi.fun();
        zi.fun1();
        System.out.println(zi.num);
//        System.out.println(zi.age);//c错误
        zi1.fun1();
        zi1.fun();
        System.out.println(zi1.num);


    }
}
