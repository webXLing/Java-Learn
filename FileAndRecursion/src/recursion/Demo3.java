package recursion;

import java.io.File;
import java.io.IOException;

/*
递归打印 多级目录
只要 .java 结尾的文件
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("FileAndRecursion");

        getAllFile(f1);
    }

    private static void getAllFile(File fl) {
        File[] files = fl.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFile(file);
            } else {
                if (file.getName().toLowerCase().endsWith(".java")) {
                    System.out.println(file);
                }
            }

        }
    }


}
