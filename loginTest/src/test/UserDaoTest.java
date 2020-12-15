package test;

import Dao.UserDao;
import cn.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("xl");
        user.setPassword("123456");

        UserDao userDao = new UserDao();

        User loginUser = userDao.login(user);
        System.out.println(loginUser);
    }
}
