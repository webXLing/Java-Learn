package file01;

import java.io.File;

/*
java.io.file 类
file 类方法

创建一个文件/文件夹
删除一个文件/文件夹
获取一个文件/文件夹
判断一个文件/文件夹 是否存在
对文件夹进行遍历
文区文件大小

file 类是一个和操作系统无关的类 任何的操作系统都可以 使用这个类中的方法

重点：
file：文件
directory 文件/目录
path 路径
 */
public class Demo1 {
    /*
    static String	pathSeparator
    与系统相关的路径分隔符字符，为方便起见，表示为字符串。
    static char	pathSeparatorChar
    与系统相关的路径分隔符。
    static String	separator
    与系统相关的默认名称 - 分隔符字符，以方便的方式表示为字符串。
    static char	separatorChar
    与系统相关的默认名称分隔符。

    pathSeparator 路径分割符 Windows：分号; linux:冒号 :
    separator 文件名称分割符 Windows：\; linux:/ :

    操作路径不能写死
    C:\delelop\a.txt

    "C:"+File.separator+"delelop"+File.separator+"a.txt"
     */
    public static void main(String[] args) {
        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);// 路径分割符

        String separator = File.separator;// 文件名称分割符
        System.out.println(separator);// 路径分割符

        File f = new File("./b.txt");
        System.out.println(f);
//        /Users/xl/longRoad/java/learnJava

    }
}
