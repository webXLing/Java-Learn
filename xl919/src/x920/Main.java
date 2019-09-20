package x920;
class Book {
    private  String title;
    private  double price;
    public Book(){
        System.out.println("新建了一个Book对象");
    }
    public Book(String title){
        this();
        this.title = title;
    }
    public Book(String title,double price){
        this(title);
        this.price = price;
    }
}
public class Main {
    public static void main(String[] args) {
        Book book = new Book("科学",12);
    }

    public void TestStringM(){

        String str1 = "Hello";
        String str2 = "HEllo";
        String str3 = "jkdkfjewgeg";
        System.out.println(str2.equals(str1)); // 字符串内容 完全相同
        System.out.println(str2.equalsIgnoreCase(str1));// 忽略大小写
        System.out.println(str2.compareTo(str1)); // -32  小写比大写大32
        System.out.println(str1.contains("ll")); // 包含
        System.out.println(str3.replaceAll("j","你好"));
        System.out.println(str3.replaceFirst("j","你好"));
        System.out.println(str3.substring(1,2));
        String []res =  str3.split("",5);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
