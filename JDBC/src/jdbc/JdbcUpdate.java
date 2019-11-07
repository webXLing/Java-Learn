package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
update 数据
 */
public class JdbcUpdate {
    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

             conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "123456");

             statement = conn.createStatement();
            int i = statement.executeUpdate("update account set money = 777 where id=4");
            if(i>0){
                System.out.println("更新数据成功");
            }else{
                System.out.println("更新数据失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
