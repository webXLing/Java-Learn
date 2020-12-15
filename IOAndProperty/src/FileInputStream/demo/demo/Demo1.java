package FileInputStream.demo.demo;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
    一次读取多个字节

 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
//        abcde
        FileInputStream fis = new FileInputStream("IOAndProperty/a.txt");
//        byte[] bytes = new byte[2];// 起到缓冲
//        int len = 0;
//
//        len = fis.read(bytes);
//        System.out.println(len);//2
//        System.out.println(bytes); // 直接打印的是地址
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(new String(bytes));//ab
//
//
//        len = fis.read(bytes);
//        System.out.println(len);//2
//        System.out.println(bytes); // 直接打印的是地址
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(new String(bytes));//cd
//
//
//        len = fis.read(bytes);
//        System.out.println(len);//1
//        System.out.println(bytes); // 直接打印的是地址
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(new String(bytes));//ed
        // 为什么 第三次返回的ed  应为第二次读取的是cd 第三次其实是读取了一个
        // 所以讲数组0所以位置覆盖为e
//        所以返回的是ed

//        上面的代码重复较多
        /*
        通过while进行优化
         */
        byte[] bytes = new byte[1024];//缓冲 存放读取的数据 1024个字节 = 1kb

        int len = 0; // 读取的有效字节个数
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }


        fis.close();


    }
}
