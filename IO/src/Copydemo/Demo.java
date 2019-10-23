package Copydemo;


import java.io.*;


/*
BufferedOutputStream 字节缓冲输出流  其实价相当于 加了个byte []
 */
class Demo {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        // 读取

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/xl/Downloads/lt@2x.png"));

//        写入
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("IO/test.png"));
////
//        int len = 0;
//
//        while ((len=bis.read())!=-1){
//            bos.write(len);
//        }
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes);
        }

        bos.close();

        bis.close();

        long e = System.currentTimeMillis();
        System.out.println("耗时"+(s-e)); //20 3

    }
}
