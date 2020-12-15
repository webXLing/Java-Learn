package recursion;

/*
递归

 方法在栈内存  所以递归更可能会造成 栈内存溢出

 */
public class Demo {
    public static void main(String[] args) {
        int num = 10;

        System.out.println(System.currentTimeMillis());
        System.out.println(sun(num));
        System.out.println(System.currentTimeMillis());

    }

    //    1+n 求和
    private static int sun(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num + sun(num - 1);

        }
    }

}
