package Dao;


import cn.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

/*
操作数据库中user 表的类
 */
public class UserDao {
    // 申明 JDBC Template 对象来公用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user 包含用户的所有信息
     */
    public User login(User loginUser){
        System.out.println("dao neibu");
        System.out.println(loginUser);
        try {
            //1、编写sql
            String sql = "select * from user where username = ? and password = ?";

            // 2、执行sql
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
            System.out.println(user);

            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
