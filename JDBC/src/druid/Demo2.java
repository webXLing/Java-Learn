package druid;

import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo2 {
    public static void main(String[] args) {
        /*
        添加操作
         */
//        获取连接
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String s = "insert into account values(null,?,?)";

        try {
            preparedStatement = connection.prepareStatement(s);

            preparedStatement.setString(1, "xl");
            preparedStatement.setDouble(2, 6666.6);
            int i = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(preparedStatement, connection);
        }
    }

    @Test
    public void test() {
//        throw new Error("error");
        System.out.println("test");
    }
}
