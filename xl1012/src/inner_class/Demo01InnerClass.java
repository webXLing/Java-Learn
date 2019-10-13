package inner_class;

/*
分类
1.成员内类
2.局部内部类（不含匿名内部类）

成员内类的定义格式
修饰符 class 外部类名称{
    修饰符 class 内部类名称{

    }
}
注意：内用外，随意访问  外用内 ，需要内部类对象


内部类的使用
1.直接使用 1.1
2.间接使用 1.2
 */
public class Demo01InnerClass {
    public static void main(String[] args) {
        Body body = new Body();
//        直接使用 1.1
        body.method();

//        2.间接使用 1.2
        Body.Heart heart = new Body().new Heart();
        heart.beat();

        Outer.Inner inner = new Outer().new Inner();
        inner.beat();

    }
}
