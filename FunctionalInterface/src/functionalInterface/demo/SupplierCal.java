package functionalInterface.demo;

import java.util.function.Supplier;

/*
求数组 的最大值
 */
public class SupplierCal {
    public static int getmax(Supplier<Integer> num){
        return  num.get();
    }
}
