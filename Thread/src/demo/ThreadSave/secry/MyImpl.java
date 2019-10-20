package demo.ThreadSave.secry;
/*
同步代码块
 */
class MyImpl implements Runnable {
    Object obj = new Object();
    private int ticket = 100;
    @Override
    public void run() {

        synchronized (obj){
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
