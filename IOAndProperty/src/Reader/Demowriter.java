package Reader;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
java.io.Writer 用于写入字符流的抽象类 超类

public abstract class Writer
extends Object


FileWriter ** 文件字符输入流
public class FileWriter extends OutputStreamWriter extends Writer

字符输出流的重点
1.在FileWriter 对象的构造方法中传入 写入的目的地
2.使用write 方法将数组 写入到 内存缓冲区中（将字符转换为字节的过程）
3.使用flush 方法将数据 刷新的到文件中去
4.释放资源（也会将 内存缓冲区的数据刷新到文件中去）


 */
public class Demowriter {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("IOAndProperty/d.txt");
        fw.write("你好1");
//        fw.flush();
        fw.close();
    }
}
