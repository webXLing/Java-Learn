package learn;
/*


任何版本的java 接口都能定义抽象方法

public abstract 返回值类型  方法名称（参数列表）

注意事项
1.*接口中的抽象方法 修饰符必须为2个固定的关键字 public abstract  而且可以选择性省略
 */
public interface Demo {

    public abstract void fun1();

    abstract void fun2();

    public void fun3();

    void fun4();
}
