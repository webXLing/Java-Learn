package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
delete  数据
 */
public class JdbcDelete {
    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

             conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "123456");

             statement = conn.createStatement();
            int i = statement.executeUpdate("DELETE from account  where id=4");
            if(i>0){
                System.out.println("删除数据成功");
            }else{
                System.out.println("删除 数据失败");
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
