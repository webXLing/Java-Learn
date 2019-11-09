package druid;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import jdk.nashorn.internal.ir.CallNode;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) {
//        1.导包
//        2.定义配置文件
        Properties properties = new Properties();

//        3.加载配置文件
        InputStream resourceAsStream = Demo.class.getClassLoader().getResourceAsStream("dconfig");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        4.获取连接池对象
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection connection = dataSource.getConnection();

            System.out.println(connection);
        } catch (Exception e) {

        }
    }

}
