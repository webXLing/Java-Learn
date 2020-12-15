package login;

import utila.JDBCutil;

import java.sql.*;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
//        键盘录入
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名");
        String user = scanner.nextLine();

        System.out.println("请输入密码");
        String pass = scanner.nextLine();
        Login login = new Login();
        boolean b = login.loginFn2(user, pass);
        if (b) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }

    /*
    登录方法 获取结果 解决sql注入问题
    select * from userlist where username = 'wd' and password = 'a' or 'a' = 'a'
     */
    public boolean loginFn2(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection con = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            //        1.连接
            con = JDBCutil.getConnection();

//             定义sql
            String sql = "select * from userlist where username = ? and password = ?";
            System.out.println(sql);
//            获取执行sql 对象
            preparedStatement = con.prepareStatement(sql);

//             设置
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
//            执行sql 获取结果  就不需要传递sql
            resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // 查询到则返回true

        } catch (SQLException e) {
            e.printStackTrace();
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return false;

    }

    /*
    登录方法
     */
    public boolean loginFn(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection con = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            //        1.连接
            con = JDBCutil.getConnection();

//             定义sql
            String sql = "select * from userlist where username = '" + username + "' and password = '" + password + "'";
            System.out.println(sql);
//            获取执行sql 对象
            statement = con.createStatement();
//            执行sql 获取结果
            resultSet = statement.executeQuery(sql);
            return resultSet.next(); // 查询到则返回true

        } catch (SQLException e) {
            e.printStackTrace();
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return false;

    }
}
