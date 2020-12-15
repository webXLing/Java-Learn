package learn920;

enum Year { //枚举类的存在 只要是也为了让编译器更好比对数据 发现潜在的问题
    MON,
    TUTH
}

/**
 * enum类型
 * 通过enum定义的枚举类，和其他的class有什么区别？
 * <p>
 * 答案是没有任何区别。enum定义的类型就是class，只不过它有以下几个特点：
 * <p>
 * 定义的enum类型总是继承自java.lang.Enum，且无法被继承；
 * 只能定义出enum的实例，而无法通过new操作符创建enum的实例；
 * 定义的每个实例都是引用类型的唯一实例；
 * 可以将enum类型用于switch语句。
 * <p>
 * public final class Color extends Enum { // 继承自Enum，标记为final class
 * // 每个实例均为全局唯一:
 * public static final Color RED = new Color();
 * public static final Color GREEN = new Color();
 * public static final Color BLUE = new Color();
 * // private构造方法，确保外部无法调用new操作符:
 * private Color() {}
 * }
 */

enum Color {
    RED,
    BLUE,
    GREEN
}

public class Learn0929 {
    public static void main(String[] args) {
        Year mon = Year.MON;
        int data = 1;
        Color red = Color.RED;
        System.out.println(red.name()); // 每个枚举值 都是class实例 所以拥有一些方法
        System.out.println(red.ordinal()); // 每个枚举值 都是class实例 所以拥有一些方法

    }
}
