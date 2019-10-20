package demo.ThreadSave.secry;


/*
 解决线程安全问题
    方法一：
        同步代码块
    格式：
    synchoronized(锁对象){   synchronize   [ˈsɪŋkrənaɪz] 使……同步
    可能出现 线程安全问题的代码  访问共享数据
    }

    注意
        1.锁对象可以是 任意对象
        2.多个线程 必须使用的同一个锁对象
        3.锁对象的作用
            只让一个线程在同步代码中执行

     同步代码块 原理
     当t1 线程 遇到同步代码块
        会判断 有没有锁对象
            如果有就 进入同步
            没有    就等待其他线程执行完同步 归还锁对象后在进入同步
        当线程 执行完同步 会归还锁对象
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
