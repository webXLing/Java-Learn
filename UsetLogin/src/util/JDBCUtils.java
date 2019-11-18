package util;



import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
JDBC 工具类 使用Druid 链接池
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
//        1.加载配置文件
        Properties properties = new Properties();
        //使用  getClassLoader 获取字节输入流
        try {
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("dconfig"));

            //        2.初始化连接池
            try {
                ds = DruidDataSourceFactory.createDataSource(properties);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    1.获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }

//    2获取connection 对象

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
