package demo.secry;

class MyImpl implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
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
