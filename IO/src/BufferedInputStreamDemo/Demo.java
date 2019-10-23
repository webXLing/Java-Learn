package BufferedInputStreamDemo;

import java.io.*;

/*
BufferedInputStream 字节缓冲输入流  其实价相当于 加了个byte []
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        FileInputStream fos = new FileInputStream("IO/a.txt");

        BufferedInputStream bs = new BufferedInputStream(fos);
//        int len = 0;
//        while ((len=bs.read())!=-1){
//            System.out.println(len);
//        }
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len=bs.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }


    }
}
