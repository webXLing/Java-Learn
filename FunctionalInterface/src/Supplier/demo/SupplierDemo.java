package Supplier.demo;

import java.util.function.Supplier;

/*
java.util.function
Interface Supplier<T>

生产型接口 制定什么 就返回什么

 */
public class SupplierDemo {
    public static String getString(Supplier<String> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        String string = getString(() -> {
            return "xl";
        });
        System.out.println(string);

        String string1 = getString(() -> "学java");
        System.out.println(string1);
    }
}
