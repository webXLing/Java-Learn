package x919;
  class Test{
    public static void main() {
    }
    public void test(){
        System.out.println("我是test");
    }
}

public class StrMethod {
    final double PI = 3.14;
    public static void main(String[] args) {
//        Test.test();
        String str = "sfksdnf2342"; // 字符串=>字符
        char c = str.charAt(2); // 字符
        System.out.println(c);

        System.out.println(isNumber(str));
        char [] data = str.toCharArray(); // 字符串=>字符数组
        for (int i = 0; i <data.length ; i++) {
            data[i]-=32; // 小写转大写
            System.out.println(data[i]);
        }
        System.out.println(new String(data,1,3));//字符数组=>字符串

    }
    // 字符串是否含有数字
    public static boolean isNumber(String tem){
        char [] data = tem.toCharArray();
        for (int i = 0; i <data.length ; i++) {
            if(data[i]>'9'||data[i]<'0'){
                return false ; // 不是数字
            }
        }
        return  true;
    }
}

