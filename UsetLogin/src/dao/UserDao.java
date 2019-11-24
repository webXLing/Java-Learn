package dao;

import domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public abstract List<User> findAll();
    public User getUserByUsername(String username, String password);
    public void  addUser(User user);

    /**
     * 根据id 删除 用户
     */
    void delete(String id);

     User findUser(int id);

    void updataUser(User user);

    /**
     * 获取 总条数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 根据页码 获取 数据
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
