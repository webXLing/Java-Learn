package recursion;

/*
计算阶乘

 */
public class Demo1 {
    public static void main(String[] args) {
        int num = 4;

        System.out.println( System.currentTimeMillis());
        System.out.println(sun(num));
        System.out.println(System.currentTimeMillis());

    }
//   5! = 5*4*3*2*1
    private static int sun(int num) {
        if(num==1){
            return 1;
        }else{
            return num * sun(num-1);

        }
    }

}
