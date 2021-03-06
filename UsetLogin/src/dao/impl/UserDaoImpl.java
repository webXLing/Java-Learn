package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//获取连接池

    @Override
    public List<User> findAll() {
        // 使用jdbc 操作数据库

//        1.定义sql
        String sql = "select * from user_table";
        List<User> query = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return query;
    }

    @Override
    public User getUserByUsername(String username, String password) {
        try { // 当查询不到的时候返回null
            String sql = "select * from user_table where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void addUser(User user) {

        try {
            String sql = "INSERT into user_table values(null,?,?,?,?,?,?,'','')";
            System.out.println(user.getName());
            System.out.println(user.getGender());
            System.out.println(user.getAge());
            System.out.println(user.getAddress());
            System.out.println(user.getQq());
            System.out.println(user.getEmail());
            int update = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
            System.out.println(update);
        } catch (Exception e) {

        }
    }

    @Override
    public void delete(String id) {
        int i = Integer.parseInt(id);
        String sql = "delete from user_table where id = ?";
        template.update(sql, i);
    }

    @Override
    public User findUser(int id) {
        try {

            String sql = "select * from user_table where id = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updataUser(User user) {
        String sql = "update user_table set NAME=?,gender=?,age=?,address=?,qq=?,email=? where id = ?";
        System.out.println(user.getName());
        System.out.println(user.getGender());
        System.out.println(user.getAge());
        System.out.println(user.getAddress());
        System.out.println(user.getQq());
        System.out.println(user.getEmail());
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }


    /**
     * 获取 总条数
     *
     * @param condition
     * @return
     */
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "SELECT COUNT(*) from user_table where 1= 1 ";

        StringBuilder stringBuilder = new StringBuilder(sql);
        List<Object> list = new ArrayList<Object>();

        Set<String> strings = condition.keySet();
        for (String string : strings) {
            String value = condition.get(string)[0];
            if ("rows".equals(string) || "currentPage".equals(string)) {
                continue;
            }
            if (value != null && !"".equals(value)) {
                stringBuilder.append(" and " + string + " like ?");
                list.add("%" + value + "%");
            }
        }

        System.out.println(stringBuilder.toString());


        int i = template.queryForObject(stringBuilder.toString(), Integer.class, list.toArray());
//        System.out.println("总条数"+i);
        return i;
    }


    /**
     * 根据页码 获取 数据
     *
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "SELECT * FROM user_table where 1= 1 ";
//        LIMIT ? , ?
        StringBuilder stringBuilder = new StringBuilder(sql);
        List<Object> list = new ArrayList<Object>();

        Set<String> strings = condition.keySet();
        for (String string : strings) {
            String value = condition.get(string)[0];
            if ("rows".equals(string) || "currentPage".equals(string)) {
                continue;
            }
            if (value != null && !"".equals(value)) {
                stringBuilder.append(" and " + string + " like ?");
                list.add("%" + value + "%");
            }
        }

        stringBuilder.append(" LIMIT ? , ?");
        list.add(start);
        list.add(rows);
        System.out.println(stringBuilder.toString());
        List<User> query = template.query(stringBuilder.toString(), new BeanPropertyRowMapper<User>(User.class), list.toArray());
//        System.out.println(query);
        return query;
    }
}
