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
public interface MyInterfacePrivate {
    //    设置 默认方法
    public default void defaultMethod() {
        System.out.println("我是默认方法");
//        defaultMethodprivate();
    }

    public default void defaultMethod1() {
        System.out.println("我是默认方法");
//        defaultMethodprivate();
    }
//    private void defaultMethodprivate(){ // 解决默认方法代码重复的问题 而且实现类不能直接访问
//        System.out.println("AAAA");
//    }


    public static void staticMethod1() {
        System.out.println("我只接口中的static方法");
//        staticMethod3();
    }

    public static void staticMethod2() {
        System.out.println("我只接口中的static方法");
//        staticMethod3();
    }

//    private static void staticMethod3(){
//        System.out.println("我只接口中的static方法");
//    }
}
