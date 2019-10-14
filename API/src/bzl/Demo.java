package bzl;

/*
装箱 从基本类型转换为 对应的包装类
拆箱  从包装类 转换为 对应的基本类型
 */
public class Demo {
    public static void main(String[] args) {
        //装箱
        Integer int1 = new Integer("1");
        System.out.println(int1);

        Integer int2 = Integer.valueOf("22");
        System.out.println(int2);

//        拆箱
        int int3 = int2.intValue();
        System.out.println(int3);


    }
}
