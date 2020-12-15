package system;

public class MySystem {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());// 当前系统 毫秒值 测试程序的效率

        fun();

    }

    /*
    src -源阵列。
    srcPos -源数组中的起始位置。
    dest -目标数组。
    destPos在目标数据的起始位置。
    length -数组元素的数目被复制。
     */
    private static void fun() {
        //定义原数组
        int[] arr1 = {1, 2, 3, 4, 5, 6};

        //        定义目标数组
        int[] arr2 = {3, 6, 9, 324, 24, 34};
        System.arraycopy(arr1, 0, arr2, 0, 3);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }


}
