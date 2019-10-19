package demo.day1019;

/*
获取线程名称的两种方法
方法二

Thread.currentThread().getName());//当前线程main
 */
public class Demo1 {
    public static void main(String[] args) {

        MyThread1 mt = new MyThread1();
        mt.start(); //新线程Thread-0
        System.out.println("当前线程"+Thread.currentThread().getName());//当前线程main

    }
}

