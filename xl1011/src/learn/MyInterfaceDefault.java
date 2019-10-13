package learn;
/*
java 8 开始  接口允许 默认方法

格式
public default 返回值类型 方法名（参数列表）{
    方法体
}
备注：接口中的默认方法，是为了解决  接口升级的问题
如果没有默认 方法 那么一旦接口 升级了 那么 他的实现类就必须要 覆写这个方法
 */
public interface MyInterfaceDefault {
    public abstract void method1();

//    设置 默认方法
    public default void defaultMethod(){
        System.out.println("我是默认方法");
    }

    public static void staticMethod(){
        System.out.println("我只接口中的static方法");
    }
}
