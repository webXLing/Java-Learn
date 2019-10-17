package Demo.exception;


import java.io.FileNotFoundException;

/*
throws 处理异常对象 会抛给方法的调用者 最终交割iJVM 处理 =》终止程序
使用格式
    返回值类型 方法名 （参数）throw AAAException,BBb Exception{
        throw new AAAException();
        throw new BBAException();
    }

    Throwable 中三个 方法

        finally 无论是否出现异常  都会执行 一般用于资源释放

        如果finally 有return  返回的是finally 中的 不是 try 中的
 */
public class MyThrows {
    public static void main(String[] args) {
        try{
            System.out.println("1");

            fun("");
            System.out.println("报错之后"); // 前面出错了 后面的不执行
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }finally {//无论是否出现异常  都会执行
           //一般用于资源释放
            System.out.println("2");
        }
        int i = get(); //100
        System.out.println(i);
    }

    private static int get() {
        int a = 1;
        try {
            return a;
        }catch (Exception e){

        }finally {
            a =100;
            return a ;
        }
    }

    public static void fun (String str) throws FileNotFoundException {
        if(!str.equals("c:\\\\efwe.txt")){
            throw new FileNotFoundException("文件名不正确");
        }
    }
}
