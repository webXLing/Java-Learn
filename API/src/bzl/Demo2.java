package bzl;

/*
jdk1.5 之后
自动装箱 从基本类型转换为 对应的包装类
自动拆箱  从包装类 转换为 对应的基本类型
 */
public class Demo2 {
    public static void main(String[] args) {
        //自动装箱
        Integer in = 1;
        //in 是一个包装类 无法直接参与计算 自动拆箱 相当于 in.inValue()+1
        in = in + 1;
    }
}
