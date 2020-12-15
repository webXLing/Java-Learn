package jdbc;

import java.sql.*;

//导入jar包
//1.复制jar包到 目录
//然后右键 add as libary
public class Jdbc {

    public static void main(String[] args) throws Exception {
//        2. 注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver"); //可以注释
//        3、获取数据库连接对象
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
//        4、定义sql
        String sql = "update account set money=600 where id = 1";
//        5、获取执行sql的对象 statement
        Statement statement = con.createStatement();
//        6.执行sql
        int count = statement.executeUpdate(sql);
//        7.处理结果
        System.out.println(count);
//        8.释放资源
        statement.close();
        con.close();

//        DriverManager 驱动管理对象
//        Connection 数据库连接对象
//        Statement 执行sql对象
////        ResultSet 结果集对象
//                next() 游标下移一行
//                getXxx(参数) Xxx数据类型
//            使用方法
//                next() 游标下移一行 并返回布尔值 true 为有效行 有数据
//                获取数据 getXxx(参数) Xxx数据类型
//        PreparedStatement 执行sql对象
//            sql注入问题  在拼接sql 时  会有sql关键字  造成安全问题
//            预编译sql

    }
}
