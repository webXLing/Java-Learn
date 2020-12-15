package learn;

/*
问题描述 当要 接口代码进行重用时  这个方法不因该被 实现类直接调用 因该是私有化

解决方法
从java 9开始 接口中 允许定义私有方法
1.普通私有方法，解决多个默认方法的代码重复问题
格式
private 返回值类型 方法名（参数）{

}

2.静态私有方法 解决多个静态方法 代码重复的问题
private static 返回值类型 方法名（参数）{

}
 */
public class DemoPrivate {

    public static void main(String[] args) {
        MyInterfacePrivateImpl myprivate = new MyInterfacePrivateImpl();
//        myprivate.test(); // 当前环境java8 接口中无法使用Private
    }
}
