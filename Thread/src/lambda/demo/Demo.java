package lambda.demo;


/*
lambda 函数式 变成

使用runnable 实现多线程
 */
public class Demo {
    public static void main(String[] args) {
        Runnable runnable = new Runnableimpl();

        Thread t = new Thread(runnable);

        t.start();


//        使用匿名内部类 实现多线程  简化
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run1" + Thread.currentThread().getName());
            }
        }).start();
    }
}
