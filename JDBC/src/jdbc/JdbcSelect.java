package jdbc;

import java.sql.*;

/*
查询数据
 */
public class JdbcSelect {
    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "123456");

            statement = conn.createStatement();

            resultSet = statement.executeQuery("select * from account");
//            处理结果
            while (resultSet.next()) {//光标下移
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double money = resultSet.getDouble(3);
                System.out.println("id" + id + "name" + name + "money" + money);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
