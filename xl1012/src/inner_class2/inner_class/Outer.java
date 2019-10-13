package inner_class2.inner_class;

//public > protected > (default) /*什么都不写 本包中可以访问*/>private
//1.外部类：public 或者 (default)
//2.成员内部类：都可以
//3.局部类 ：什么都不能写


public class Outer {// 外部类
    int num = 10;


        public void beat(){//外部类方法

            class Inner{
                public void fun(){

                int num = 1;
                System.out.println(num);// 2 // 就近原则
                System.out.println(Outer.this.num); // 10 外部类的成员变量
                System.out.println("nei部类方法 beat");
                }
            }


        }

//    外部类成员变量
    private String name;


}
