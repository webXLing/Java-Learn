package FileOutputStream.demo;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
    换行以及续写

    true 为续写
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("IOAndProperty/c.txt", true);
        for (int i = 0; i < 10; i++) {
            fos.write("你好".getBytes());
            fos.write("\r\n".getBytes()); //换行
        }
    }
}
