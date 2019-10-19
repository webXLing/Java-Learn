package demo.day1019;

/*
匿名内部类实现线程的创建
匿名 没有名字
内部类 写在其他类内部的类

格式
 new 父类/接口（）「
    重写
 」
         */
public class InnerClassThread {
    public static void main(String[] args) {
//        new MyThread().start(); //本来是这样
        new Thread(){
            @Override
            public void run() {
                System.out.println("匿名内部类");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        }.start();

//        线程的接口 runnAble
//        RunnAble rn = new RunnAbleImpl();  之前
        Runnable r= new Runnable(){
            @Override
            public void run() {
                System.out.println("匿名内部类 RunnAble"+Thread.currentThread().getName());
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        };
        new Thread(r).start();
    }
}
