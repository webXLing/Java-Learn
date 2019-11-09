package trasaction;


import utila.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
事务
 */
public class Demo1 {
    public static void main(String[] args) {
//        注册 获取连接对象
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        try {
            connection = JDBCutil.getConnection();

//            开启事务
            connection.setAutoCommit(false);

//            Sql  张三 -500
            String sql1 = "update account set money = money + ? where id = ?";
            String sql2 = "update account set money = money + ? where id = ?";

//            获取sql 对象
             preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);

//            设置值
//            张三 -500
            preparedStatement1.setDouble(1,-500);
            preparedStatement1.setInt(2,1);

            // 李四 +500
            preparedStatement2.setDouble(1,500);
            preparedStatement2.setInt(2,2);

            // 执行sql
            preparedStatement1.executeUpdate();

            int i = 3/0;
            preparedStatement2.executeUpdate();
            connection.commit(); // 提交事务
        } catch (Exception e) {
            // 回滚
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCutil.close(preparedStatement1,connection);
            JDBCutil.close(preparedStatement2,connection);
        }
    }
}
