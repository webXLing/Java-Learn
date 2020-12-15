package inner_class;

public class Outer {// 外部类
    int num = 10;

    public class Inner {
        int num = 1;

        public void beat() {//外部类方法
            int num = 2;
            System.out.println(num);// 2 // 就近原则
            System.out.println(this.num); // 1 内部类的成员变量
            System.out.println(Outer.this.num); // 10 外部类的成员变量
            System.out.println("nei部类方法 beat");
        }

    }

    //    外部类成员变量
    private String name;


}
