package BufferedWriterDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("IO/writer.txt"));

        for (int i = 0; i < 6; i++) {
            bw.write("今天学习了IOliu ");
//            bw.write("\r\n");
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}
