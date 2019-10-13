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
public class MyInterfacePrivateImpl implements MyInterfacePrivate {

    public void test(){
        defaultMethod(); // 实现类可以直接访问 接口中的 默认方法
//        defaultMethodprivate(); // 该方法在接口是private 所以不能直接访问
        MyInterfacePrivate.staticMethod1();
        MyInterfacePrivate.staticMethod1();
        // 错误 这个静态方法是  私有的
//        MyInterfacePrivate.staticMethod3();
    }
}
