package demo.ThreadSave.secry1.secry;
/*
同步代码块
 */
class MyImpl implements Runnable {
    Object obj = new Object();
    private int ticket = 100;
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

    public synchronized void Pay(){
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
