package demo.ThreadSave.secry2.secry.secry;


/*
 解决线程安全问题
    方法二：
        静态的同步方法
    步骤
        1、吧访问了共相数据的代码 抽取出来 放在一个方法中去
        2、在这个方法上 添加关键字 synchronize


    注意
        1.锁对象可以是 任意对象
        2.多个线程 必须使用的同一个锁对象
        3.锁对象的作用
            只让一个线程在同步代码中执行

     同步方法 原理
     其实也是用了 锁对象控制 默认就是this  该实现类对象
     Runnable my1 = new MyImpl();

 */
public class Demo {
    public static void main(String[] args) {
        Runnable my1 = new MyImpl();

        // 创建三个线程同时 去买这个100张票

        /*
        出现线程安全问题
        Thread-2正在买第1
        Thread-0正在买第1
        Thread-1正在买第-1
         */

        // 开启三个线程 去抢占cpu的执行权
        new Thread(my1).start();
        new Thread(my1).start();
        new Thread(my1).start();
    }
}
