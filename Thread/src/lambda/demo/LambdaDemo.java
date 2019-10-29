package lambda.demo;

public class LambdaDemo {
    public static void main(String[] args) {
//        使用匿名内部类实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run1"+Thread.currentThread().getName());
            }
        }).start();


//        lambda 表达式
        new Thread(()->{
            System.out.println("run1++++"+Thread.currentThread().getName());
        }).start();
    }

}
