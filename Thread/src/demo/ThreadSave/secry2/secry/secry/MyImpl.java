package demo.ThreadSave.secry2.secry.secry;
/*
同步代码块
 */
class MyImpl implements Runnable {
    Object obj = new Object();
    static int ticket = 100;
    @Override
    public void run() {

        synchronized (obj){
            System.out.println("run");
            Pay();
//            while (ticket>0){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+"正在买第"+ticket);
//                ticket--;
//            }
        }

    }

    /*
    静态的同步方法
    锁对象 不是this
    是本类的class文件
     */
    public static /* synchronized */ void Pay(){
        synchronized (MyImpl.class){
            while (ticket>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在买第"+ticket);
                ticket--;
            }
        }
    }
}
