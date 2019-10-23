package Reader;


import java.io.FileReader;
import java.io.IOException;

/*
java.io.Reader 字符输入流的 超类

public abstract class Reader
extends Object
implements Readable, Closeable

FileReader **
public class FileReader extends InputStreamReader extends Reader

作用 将硬盘中的文件数据 以字符文件的形式读取到内存当中去

JDK7 新特性 中try后面可以跟一个（） ，(中可以放变量声明 这样作用域为在try中 )
try(定义流对象；定义流对象；){
}catch(异常类型 e){
}

 */
public class Demo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("IOAndProperty/a.txt");

//        int len = 0;
//        while ((len= fr.read())!=-1){ //只读取一个字符 并返回
//            System.out.println(len);
//            System.out.println((char)len);
//        }

        char[] chars = new char[1024];
        int len = 0;
        while ((len = fr.read(chars))!=-1){
            System.out.print(new String(chars,0,len));
        }
    }
}
