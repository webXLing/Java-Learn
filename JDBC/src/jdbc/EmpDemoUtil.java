package jdbc;

import domain.Emp;
import utila.JDBCutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
定义一个方法 查询emp表的数据将其变为一个对象 装载集合后 返回
 */
public class EmpDemoUtil {
    public static void main(String[] args) throws SQLException {
        List<Emp> list = new EmpDemoUtil().findAll();
        System.out.println(list);
    }

    public List<Emp> findAll() {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Emp> emps = null;
        try {

            conn = JDBCutil.getConnection();
            statement = conn.createStatement();
            //执行sql
            resultSet = statement.executeQuery("select * from employee");

            emps = new ArrayList<Emp>();
            Emp emp = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                int dep_id = resultSet.getInt("dep_id");
                emp = new Emp();
                emp.setAge(age);
                emp.setId(id);
                emp.setDep_id(dep_id);
                emp.setName(name);
                emps.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutil.close(resultSet, statement, conn);
//            if(resultSet!=null){
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(statement!=null){
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }

            return emps;
        }
    }
}
