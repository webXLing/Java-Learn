package Demo.exception;

/*
子父类的异常
    -父类如果抛出多个异常，子类重写父类方法时 抛出和父类相同的异常 或者父类异常的子类 或者不抛出
    -父类方法没有抛出异常 子类重写父类该方法时也可以不抛出异常 此时子类产生该异常 只能捕获处理 不能生命处理
注意
 父类异常什么样 子类异常就什么样
 */
public class Fu {
    public void show1() throws NullPointerException,ClassCastException{}
    public void show2() throws IndexOutOfBoundsException{}
    public void show3() throws IndexOutOfBoundsException{}

    public void show4(){}
}
class Zi extends Fu{
//    子类重写父类方法时 抛出和父类相同的异常
    public void show1() throws NullPointerException,ClassCastException{}
//    或者父类异常的子类
    public void show2() throws ArrayIndexOutOfBoundsException{}
//    或者不抛出
    public void show3(){}

    //    父类方法没有抛出异常 子类重写父类该方法时也可以不抛出异常
//    public void show4() throws Exception {}

//    只能捕获处理
        public void show4()  {
        try {
            throw new Exception("");

        }catch (Exception e){

        }
        }

}

