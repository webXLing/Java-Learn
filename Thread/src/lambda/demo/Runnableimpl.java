package lambda.demo;

//实现Runnable 接口 重写run方法 设置线程任务
public class Runnableimpl implements Runnable {
    @Override
    public void run() {
        System.out.println("run"+Thread.currentThread().getName());
    }
}
