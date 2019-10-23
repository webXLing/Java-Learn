package FileOutputStream.demo;


import sun.jvm.hotspot.oops.Array;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
java.io.OutputStream  这个抽象类是表示 字节输 出流的所有类的超类。 输出流接收输出字节并将其发送到某个接收器。

    public class FileOutputStream extends OutputStream  文件输出流
    作用：将内存中的数据 写入到硬盘的文件中

    public void write(int b)
           throws IOException
    将指定的字节写入此文件输出流。 实现write方法OutputStream 。

    write(byte[] b)
    将 b.length个字节从指定的字节数组写入此文件输出流。

    public void close()
           throws IOException
    关闭此文件输出流并释放与此流相关联的任何系统资源。 此文件输出流可能不再用于写入字节。
    如果该流具有相关联的信道，则该信道也被关闭。

    构造方法

    写入数据的原理（内存->硬盘）
    java程序->JVM虚拟机->os操作系统->os调用写数据方法->把数据写入文件

    步骤 重点：
    1.创建一个FileOutputStream对象，构造方法中能够传递 写入数据目的地
    2.调用对象write 方法写入数据
    3.释放资源（刘使用会占用一定的资源）

    字节流的问题 在读中文的时候可能会乱码  utf-8 中文占3个字节 GBK中文占用两个字节
共性成员方法
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("IOAndProperty/b.txt");
//        public void write(int b)

        fos.write(49); // a 的asc码是97
        fos.write(48);
        fos.write(48);

        /*
          write(byte[] b)
         一次写入多个字节
            如果第一个字节 是 0-127 那么就查询ASCII
            如果是负数 则和后面一个字节 组成一个中文
         */
        byte [] bytes = {65,66,67,68,69}; //ABCDE
        byte [] bytes1 = {-65,66,-67,68,69}; // 100柯侥E  -65和66组成一个中文 -67,68,组成一个中文
        fos.write(bytes1);


          /*
          write(byte[] b, int off, int len)
         一次写入多个字节
            如果第一个字节 是 0-127 那么就查询ASCII
            如果是负数 则和后面一个字节 组成一个中文
         */
        byte [] bytes2 = {65,66,67,68,69};
        byte [] bytes3 = {-65,66,-67,68,69}; // 100柯侥E  -65和66组成一个中文 -67,68,组成一个中文
        fos.write(bytes2,0,1);

        byte[] chars = "你好".getBytes(); //
        System.out.println(Arrays.toString(chars));
        //[-28, -67, -96, -27, -91, -67]
        //    utf-8 一个中文3三个字节

        fos.write(chars);

//        释放资源
        fos.close();
    }
}
