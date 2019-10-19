package demo.day1019;

/*
public static void sleep(long millis)
                  throws InterruptedException
使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）
，具体取决于系统定时器和调度程序的精度和准确性。 线程不会丢失任何显示器的所有权。
 */
public class Sleep {
    public static void main(String[] args) {
//        相当于interval
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
