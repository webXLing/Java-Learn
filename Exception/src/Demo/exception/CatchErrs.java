package Demo.exception;


import java.util.ArrayList;

/*
多个异常处理
    1.多个异常分别处理
    2.多个异常一次捕获，多次处理
        一个try 多个catch
        如果catch 的异常变量 如果有子父类 关系 必须子类写上面父类写下面
    3.多个异常一次捕获一次处理
 */
public class CatchErrs {
    public static void main(String[] args) {
        int[] arr = {1, 34, 43};
        System.out.println(arr[6]);

        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("lx");
        arr1.add("lx");
        arr1.add("lx");

//        arr1.add(6);
    }
}
