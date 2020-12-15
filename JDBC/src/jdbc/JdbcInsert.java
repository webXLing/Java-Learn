package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
account 表添加  添加一条数据
为什么这个一场不能交个jvm 因为资源要去释放 所以通过finally 即使程序出错了 我们也能够去释放资源
 */
public class JdbcInsert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;

        try {
            //        1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

//            2.定义sql
            String sql = "insert into account values(null,'王五',6666)";

//            3.获取connection 对象
            conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "123456");

//            4.获取执行sql的satetment 对象
            statement = conn.createStatement();

//        5.执行sql
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();// 释放资源
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();// 释放资源
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
