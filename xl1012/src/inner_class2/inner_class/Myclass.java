package inner_class2.inner_class;
/*
局部类 如果想访问所在方法 局部变量 那么这个局部变量 必须是「有效的final」

备注 从java8+开始，只要局部变量世事不变 那么final关键字可以省略

原因
1.new 出来的对象在堆内存当中
2.局部变量是跟着方法走的 ，当方法运行完 立刻出栈 局部变量就会消失
3.new出来的对象会在堆内存中持续存在 直至垃圾回收

这个对象活的  比num 久 所以你num是不变的 那么我之间copy下 当做常量就好了
 */
public class Myclass {

    public void fun(){
        int num = 10;
        num = 20;
        class MyInner{
            public void get(){
//                System.out.println(num); // 报错
            }
        }
    }

    public void fun1(){
        int num = 10; // 后续num 不变则 默认为final
        class MyInner{
            public void get(){
                System.out.println(num); // 不报错
            }
        }
    }
}
