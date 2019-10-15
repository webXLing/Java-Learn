package myset;

/*
 可变参数 ...
 jdk 1.5以后 出现的新特性
 适用前提
 当方法的参数列表的数据类型已经确定 但个数不定 可以使用
 格式
 修饰符 返回值类型 方法名（数据类型...变量名）「
 」
 */
public class kbcs {
    public static void main(String[] args) {
        add();
        add(1,34,2);
        add(2,3);
    }

    private static int add(int ...arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res +=arr[i];
        }
        System.out.println(res);
        return res;
    }
}
