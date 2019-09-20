package learn920;

// 抽象类 就是 用来被继承 作为一种规范 强迫子类实现其方法
//如果抽象了只有抽象方法 那么就可以改写成抽象接口 interface
abstract class Human{
//    int num=1;
    abstract String say(String str);
}

// 方法默认 添加两个 修饰符 public static
interface Myinter{
    // 编译器会自动加上public statc final:  interface的字段只能是public static final类型
    int num =2;
    void getMoney ();
}

class Person extends  Human {
    protected String name;
    public void getName(){
        System.out.println("xL");
    }

    @Override
    public String say (String str){
        System.out.println(str);
        return str;
    }
    public static void getAge(){
        System.out.println(23);
    }

    private static void getHeight(){
        System.out.println("20cm");
    }
}

class Student extends Person implements Myinter{
    public static void main(String[] args) {
    }
    @Override
    // 参数 方法名 返回值 都须一致
    public void getName(){
        System.out.println("sdt");
    }

    @Override
    public void getMoney() {
        System.out.println("今天挣了"+100);
    }
}
public class MyClass {

    public static void main(String[] args){
//        Test1.
//        方法重载  这种方法名相同，但各自的参数不同，称为方法重载（Overload）。
        Student sdt = new Student(); //
        sdt.getName();
        sdt.say("sds");
        sdt.getMoney();
        System.out.println(sdt.num);

    }
}
