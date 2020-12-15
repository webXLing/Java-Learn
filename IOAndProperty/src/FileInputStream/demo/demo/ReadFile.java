package FileInputStream.demo.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        // 创建字节输入流对象
        FileInputStream fis = new FileInputStream("/Users/xl/Downloads/lt@2x.png");

        // 创建 字节输出流对象
        FileOutputStream fos = new FileOutputStream("IOAndProperty/test.png");

//        int len = 0; // 存取读取的字节
//        while ((len=fis.read())!=-1){//默认读取一个字节 1 byte
//            System.out.println(len);
////                        System.out.println((char)len);
//
//            fos.write(len);
//        }
        int len = 0;// 读取的有效字节数
        byte[] bytes = new byte[1024]; // 缓冲区 存储 一个kb = 1024个字节
        while ((len = fis.read(bytes)) != -1) {//默认读取一个字节 1 byte
//                        System.out.println((char)len);

            fos.write(bytes, 0, len);
        }

        fos.close();
        fis.close();

        long e = System.currentTimeMillis();

        System.out.println("耗时：" + (e - s));
        //2388
        //4

    }
}
