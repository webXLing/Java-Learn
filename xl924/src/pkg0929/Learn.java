package pkg0929;
class A{
    public A(){
        System.out.println("wo shi A");
    }
}

class B extends A{
    public B(){
        System.out.println("wo shi B");
    }

    public void fun(){
        System.out.println("wo shi fun");
    }
}


abstract class Action{
    public static final int EAT=1;
    public static final int SLEEP=7;
    public static final int WORK=5;

    public void command(int flag){
        switch (flag){
            case EAT:
            this.eat();
            break;
            case SLEEP:
                this.sleep();
                break;
            case WORK:
                this.work();
                break;
            case EAT+ WORK:
                this.eat();
                this.work();
                break;
        }
    }

    public abstract void eat();
    public abstract  void sleep();
    public abstract void work();
}

class Robot extends Action{
    @Override
     public void eat(){
         System.out.println("机器人 充电");
     }

    @Override
    public void sleep() {

    }

    @Override
    public void work() {
        System.out.println("机器人 工作");
    }
}
class Human extends Action{
    @Override
    public void eat(){
        System.out.println("人 吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("人 睡觉");
    }

    @Override
    public void work() {
        System.out.println("人 工作");
    }
}
class Pig extends Action{
    @Override
    public void eat(){
        System.out.println("猪 吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("猪 睡觉");
    }

    @Override
    public void work() {
    }
}

public class Learn {
    public static void main(String[] args) {
        A a = new B();
//        a.fun();  // A 类型中没有fun 方法 需要进行向下转型
        B b = (B) a;
        b.fun();

        commond(new Pig());//调用 方法 该方法肯定是 今天方法 不需要实例化
//        commond(new Human());
//        commond(new Robot());
    }

    public static void commond (Action ac){
        ac.command(Action.EAT);
        ac.command(Action.SLEEP);
        ac.command(Action.WORK);
    }

//    先向上转型 这样可以统一参数类型 只有向上转型之后才可以进行向下转型
}
