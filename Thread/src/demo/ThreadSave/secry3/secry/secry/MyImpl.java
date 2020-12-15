package demo.ThreadSave.secry3.secry.secry;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Lock
 */
class MyImpl implements Runnable {
    private int ticket = 100;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {

        System.out.println("run");
        lock.lock(); // 获得锁。

        while (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在买第" + ticket);
            ticket--;
        }
        lock.unlock(); //释放锁

    }

    public synchronized void Pay() {
        while (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在买第" + ticket);
            ticket--;
        }
    }
}
