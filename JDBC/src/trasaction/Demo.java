package trasaction;



/*
 * 演示转账方法
 * 所有对Connect的操作都在Service层进行的处理
 * 把所有connection的操作隐藏起来，这需要使用自定义的小工具（day19_1）
 * */

import utila.JDBCutil;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {

    }

    public void transferAccounts() {
        Connection connection = null;

        try {
            connection = JDBCutil.getConnection();

//            开启事务
            connection.setAutoCommit(false);

            AccountDao accountDao = new AccountDao();

            accountDao.updateBalance(connection, "王五", 777.77);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
