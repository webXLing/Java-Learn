package Prop;


import java.io.*;
import java.util.Properties;
import java.util.Set;

/*
public class Properties extends Hashtable<Object,Object>
Properties类表示一组持久的属性 和io流相关
双列集合  继承了Set 集合
    store
    load
 */
public class DemoProperties {
    public static void main(String[] args) throws IOException {
        show();
        show2();

        show3();
    }
//    load
//    将对应的文件 从硬盘中保存到 properties 中
    private static void show3() throws IOException {
//        FileReader fr = new FileReader("IOAndProperty/prop1.txt");// 字符流不会乱码
        FileInputStream fr =new FileInputStream("IOAndProperty/prop1.txt");//就会乱码
        Properties properties = new Properties();

        properties.load(fr);

        Set<String> strings = properties.stringPropertyNames();//去除每个key
        for (String string : strings) {
            String property = properties.getProperty(string);
            System.out.println(string +":" +property);
        }
    }


    /*
    public void store(Writer writer,
                  String comments)
           throws IOException

    public void store(OutputStream out,
                  String comments)
           throws IOException
    comments 注释 不能用中文
    Writer 可以中文
    OutputStream 不可以有中文
     */


    private static void show2() throws IOException {
        Properties prop = new Properties();

        prop.setProperty("xl","18岁");
        prop.setProperty("今天","10月23号");
        prop.setProperty("加油","学java");

//
//        FileWriter fw = new FileWriter("IOAndProperty/prop1.txt");
        FileOutputStream fw = new FileOutputStream("IOAndProperty/prop3.txt");
        // 字节流 就乱码了

        prop.store(fw,"sabe by FileOutput");

        fw.close();

//        使用匿名对象 使用完就没了
//        prop.store(new FileWriter("IOAndProperty/prop2.txt"),"savedata2");


    }


    private static void show() {
        Properties prop = new Properties();//默认为string 泛型

        prop.setProperty("xl","18岁");
        prop.setProperty("今天","10月23号");
        prop.setProperty("加油","学java");

        Set<String> strings = prop.stringPropertyNames();// 获取keys 在set集合中

        for (String string : strings) {
            String property = prop.getProperty(string);
            System.out.println(string+":"+property);
        }

    }
}
