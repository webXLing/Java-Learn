package pkg1008;

/**
 * * 接口在实际开发中三大核心作用
 * * 定义不同层之间的操作标准
 * * 表示一种操作的能力
 * * 表示将服务器端的视图 暴露给客户端
 */

//定义规范 定义不同层之间的操作标准
interface USB {
    public void start();

    public void stop();
}

class U implements USB {
    @Override
    public void start() {
        System.out.println("u 盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println(" u 盘结束功能工作");
    }
}

//电脑
class Computer {
    public void plugin(USB usb) {
        usb.start();
        usb.stop();
    }
}

public class Learn1 {
    public static void main(String[] args) {
        System.out.println("1");
        Computer computer = new Computer();
        U u = new U();
        computer.plugin(u);
    }
}
