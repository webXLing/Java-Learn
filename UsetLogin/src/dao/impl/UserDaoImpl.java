package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;


import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());//获取连接池

    @Override
    public List<User> findAll() {
        // 使用jdbc 操作数据库

//        1.定义sql
        String sql = "select * from user_table";
        List<User> query = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        System.out.println(query);
        return query;
    }
}
