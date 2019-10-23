package BufferedOutputStreamDemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
BufferedOutputStream 字节缓冲输出流  其实价相当于 加了个byte []
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("IO/a.txt");

        BufferedOutputStream bs = new BufferedOutputStream(fos);

        bs.write("今天是个好日子 加油".getBytes());

        bs.flush();// 内存缓冲区的 数据 刷新到 文件当中去
        bs.close();

    }
}
