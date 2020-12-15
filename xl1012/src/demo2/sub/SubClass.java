package demo2.sub;

// 不是同一个包 所以需要导包 语句

import demo2.MyClass;

// sub 包 和  demo2 算不同包
public class SubClass extends MyClass {
    public void fun() {
        System.out.println(super.num);
    }
}
