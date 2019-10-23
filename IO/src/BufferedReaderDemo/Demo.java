package BufferedReaderDemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
BufferedReader

public String readLine()
                throws IOException
读一行文字。 一行被视为由换行符（'\ n'），回车符（'\ r'）中的任何一个或随后的换行符终止。
结果
包含行的内容的字符串，不包括任何行终止字符，如果已达到流的末尾，则为null
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("IO/writer.txt"));

//        System.out.println(bufferedReader.readLine()); //今天是个好日子 加油
//        System.out.println(bufferedReader.readLine()); //今天是个好日子 加油
        String str ;
        while (( str = bufferedReader.readLine()) != null){
            System.out.println(str);
        }
    }
}
