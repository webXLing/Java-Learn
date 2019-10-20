package demo.ThreadSave.secry3.secry.secry;


/*
 解决线程安全问题
    方法二：
         Lock 锁
    java.util.concurrent.locks
    Interface Lock

    java.util.concurrent.locks.ReentrantLock implements Lock
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
