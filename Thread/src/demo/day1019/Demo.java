package demo.day1019;


//
//并发 指的是  多件事情 同时让一个cpu处理  cup 只能在多件事情间非常快速的来回切换
//并行 指的是  多件事情 由多个cpu 处理 这样多件事情可以同时的 进行

/*
java.lang.Thread
    实现多线程
        方法一
        1.创建Thread子类
        2.Thread子类 重写run方法 设置 线程任务
        3.创建Thread子类 对象  调用start 方法 开启线程

        方法二  实现 Interface Runnable

        两种方式的区别
        Runnable
            优点
                1.避免单继承的缺陷
                2.设置任务和 开启线程 进行了分离（解耦）

        void	start()
导致此线程开始执行; Java虚拟机调用此线程的run方法。

结果是两个线程同时运行：当前线程（从调用返回到start方法）和另一个线程（执行其run方法）。
不止一次启动线程是不合法的。 特别地，一旦线程完成执行就可能不会重新启动。

Java程序属于抢占式调度 优先级高的先执行 优先度相同 随机
 */
class MyRun implements Runnable{
    @Override
    public void run() {
        System.out.println("我是MyRun 的run 方法");
    }
}
public class Demo {
    /*
    JVM 执行main放方法 找os操作系统 开辟一条通往cpu的路径 这个路径叫 main线程（主线程）
    cpu 通过这个线程 可以执行main 方法
     */
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();

//        主线程 和 创建的线程 随机执行
        for (int i = 0; i <20 ; i++) {
            System.out.println("主线程"+i);
        }

//        方法二
        MyRun myRun = new MyRun();
        Thread t = new Thread(myRun);
        t.start();
    }
}
