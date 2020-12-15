package FileInputStream.demo.demo;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
java.io.InputStream
  这个抽象类是表示输入字节流的所有类的超类。
。
	read()
    从输入流读取数据的下一个字节
    。
    read(byte[] b)
    从输入流读取一些字节数，并将它们存储到缓冲区 b 。


    public class FileInputStream extends InputStream
    将硬盘中文件的内容 读取到 内存当中

    构造方法

    读取数据的原理（硬盘 -> 内存）
    java程序->JVM虚拟机->os操作系统->os调读取数据方法->读取文件

    步骤 重点：
    1.创建一个FileInputStream对象，
    2.调用对象read 方法读取数据
    3.释放资源（刘使用会占用一定的资源）

共性成员方法
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("IOAndProperty/a.txt");

        /*
        read()
        从该输入流读取一个字节的数据。
        当读取文件的末尾 返回-1
         */
//        int read = fis.read();
//        System.out.println(read);
//
//
//         read = fis.read(); //
//        System.out.println(read);

        int length = 0;
        while ((length = fis.read()) != -1) {
            System.out.println((char) length);
        }

        fis.close();


    }
}
