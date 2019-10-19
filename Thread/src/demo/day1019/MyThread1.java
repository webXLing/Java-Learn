package demo.day1019;

/*

方法1
getName
public final String getName()
返回此线程的名称。

 */
class MyThread1 extends Thread{
    @Override
    public void run() {
        String name = getName();
        System.out.println("新线程"+name);

    }
}
