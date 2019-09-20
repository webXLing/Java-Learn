package learn920;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
//        var str = "ds"; // java 10 之后的
//        System.out.println(str);
        int n = 5;
        double res = 1.3+24.0/n;
        double d = 1.2 + 24 / 5;  // 4
        System.out.println(res);
        System.out.println(d);

        int[] arr;
//        arr =new int[]{1,23,43,454,5};
//        System.out.println(arr);
//        arr=new int[]{1};
//        System.out.println(arr[2]); // ArrayIndexOutOfBoundsException 索引超出 数组的大小在赋值的时候就规定了

        double d1 = 1301123000;
        double d2 = 3.123123;
        System.out.println(d1);
        System.out.printf("d1=%f",d2);
        int n1 = 12345000;
        System.out.printf("n=%d, hex=%08x", n1, n1); // 注意，两个%占位符必须传入两个数

//        java 输出
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.print("Input your name: "); // 打印提示
        String name = scanner.nextLine(); // 读取一行输入并获取字符串
        System.out.print("Input your age: "); // 打印提示
        int age = scanner.nextInt(); // 读取一行输入并获取整数
        System.out.printf("Hi, %s, you are %d\n", name, age); // 格式化输出

//        foreach
        int [] arr2 = new int[]{1,321,3423,423};
        for (int item:
             arr2) {
            System.out.println(item);
        }
    }
}
//一个*.java文件只能有一个public class 类
//public class 与 class 的区别
//对个class 会被编译为多个java文件
class Book {
    //    static int num;
    private int num;//私有属性 只能在本类中访问
    String str;
    double price;
    //    public static void show(){
    public void show(){

        System.out.println("排名"+num);

        System.out.println("名称"+str);
        System.out.println("价格"+price);
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}

//简单java类
class Emp{
    private String ename;
    private String job;
    private double sal;
    private double com;
    public Emp(){//无参构造

    }
    public Emp(String name,String j,double sa,double c){//无参构造
        ename = name;
        job=j;
        sal=sa;
        com=c;
    }
    public void setEname(String name){
        ename = name;
    }
    public void setJob (String j){
        job = j;
    }
    public void setSal(double s){
        sal=s;
    }
    public void setCom(double c){
        com = c;
    }
    public String getEname(){
        return ename;
    }
    public String getJob(){
        return job;
    }
    public double getSal(){
        return sal;
    }
    public double getCom(){
        return com;
    }
    public String getInfo(){
        return "名字:"+ename+"\n"+
                "职业："+job+"\n"+
                "工资"+sal+"\n"+
                "不知道"+com+'\n';
    }
}
 class Test {
    public static void main(String[] args){
        Emp emp = new Emp("小红","前端",7.0,1);
        emp.setJob("后端");
        System.out.println(emp.getInfo());
        /**类的引用*/
//        Book book1 = new Book();
//        book1.str="小红书";
//        book1.price=99.0;
//        book1.show();
//        book1.setNum(1);
//
//        System.out.println(book1.getNum());
//        System.out.println("我是换行的hello word");
//        System.out.print("我是不换行的hello word");
//        System.out.print("我是不换行的hello word");
        /**
         * 字符 基本类型 char
         */
//        char A = 'A';//单引号 字符 双引号字符串
//        char a = 'a';//单引号 字符 双引号字符串
//
//        int num = a;
//        int num1 = A;
//        System.out.print(a);
//        System.out.print(num);//字符需要转化为int 才能进行加法计算
//        System.out.print(num1);//字符需要转化为int 才能进行加法计算  A-65   a-97  大小写编码 差32
//
//        int b = num +1;
//        a = (char)b;
//        System.out.println(a);//字符需要转化为int 才能进行加法计算
//        System.out.println(A);//字符需要转化为int 才能进行加法计算
//
//        char change = (char)num1;
//        System.out.println(change);//字符可以和int  相互转化

        /**
         * 字符串 基本类型 类 String
         */
//        String str = "hello";
//        System.out.println(str);//字符串变量
//        System.out.println("hell\" \n \to");//字符串常量
//        数据类型的转换永远是小范围自动向大范围转换 如果将大范围转变为小范围要 进行强制转换 还可能会出现数据溢出
//
//        int num1 = 10;
//        int num2 = 20;
//        int result = num1++ + num2;//先计算再自增
//        System.out.println(num1);//11
//        System.out.println(result);//30

//        int a = 9;
//        int b = 11;
//        System.out.println(a & b);//9  位与运算
//00000000 00000000 00000000 00001001   9
//00000000 00000000 00000000 00001011   11
//00000000 00000000 00000000 00001001   9
//        System.out.println(a | b);//9  位或运算
//00000000 00000000 00000000 00001001   9
//00000000 00000000 00000000 00001011   11
//00000000 00000000 00000000 00001011   11
        /**
         * 位运算
         */
//        最快的方式计算2的3次方的结果  节约内存空间
//        int num = 2;
//        int res = num<<2;//向左移动2位  二进制
//        System.out.println(num);//原始数据不变
//        System.out.println(res);
        //00000000 00000000 00000000 00000010   2
        //00000000 00000000 00000000 00001000   8

//        “&” 和 “&&” 的区别 “|” 和 “||”
//        逻辑运算上
//                普通与“&”：所有判断条件都要判断
//                短路与“&&”：如果前面判断返回false 后面不在判断 直接返回false
//
//                普通或“|”：所有判断条件都要判断
//                短路或“||”：如果前面判断返回 后面不在判断 直接返回true
//        位运算上
//                位于运算& 位或运算|  && || 不能用于位运算
    }
}
// class Test1 {
//    public static void main(String[] args){
//        System.out.println("我是换行的hello word");
//        System.out.print("我是不换行的hello word");
//        System.out.print("我是不换行的hello word");
//
//    }
//}

//3中注释
// 单行注释
/* 多行注释
 */

/**
 * 文档注释
 */
//
//.如果想表示整数就是用int 想表示小数就用double
//.如果想描述日期时间数字或者文件(内存)的大小 使用long
//.如果要实现内容的传递或者编码的转换 使用byte  -128-127
//.逻辑控制用boolean
//.想用中文 使用char可以避免乱码的问题
//大范围的数据类型往小范围的数据类型 转化 需要强制的转换
//byte<int<long<double
