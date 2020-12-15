package inner_class;

//Body$Heart.class 内部类的.class 文件名
public class Body {// 外部类

    public class Heart {

        public void beat() {//外部类方法
            System.out.println("nei部类方法 beat");
        }

    }

    //    外部类成员变量
    private String name;

    //    外部类方法
    public void method() {
        System.out.println("外部类方法");
        Heart heart = new Heart();
        heart.beat();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
