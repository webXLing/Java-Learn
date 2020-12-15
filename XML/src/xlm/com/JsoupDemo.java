package xlm.com;

public class JsoupDemo {
    public static void main(String[] args) {
//        获取index.xml 文件路径
        String path = JsoupDemo.class.getClassLoader().getResource("index.xml").getPath();
        System.out.println(path);
    }
}
