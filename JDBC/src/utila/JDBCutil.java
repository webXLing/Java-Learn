package utila;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/*
JDBC 工具类
 */
public class JDBCutil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver ;


    //    配置的读取 只需读取一次 所以用静态代码块
    static {

//        加载文件
        try {
//            ClassLoader 类加载器
//            创建Properties集合、
            Properties properties = new Properties();
            ClassLoader classLoader = JDBCutil.class.getClassLoader();
            URL resource = classLoader.getResource("jdbcconfig");// 默认在src下

            String path = resource.getPath();

//            加载文件
            properties.load(new FileReader(path));

            url=properties.getProperty("url");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            driver=properties.getProperty("driver");
            System.out.println(driver);

//            注册驱动
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //返回Connection 对象 连接 对象
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }


    //关闭资源
    public static void close(Statement statement,Connection connection){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //关闭资源
    public static void close(ResultSet resultSet, Statement statement, Connection connection){

        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
