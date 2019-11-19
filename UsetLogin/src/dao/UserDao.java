package dao;

import domain.User;

import java.util.List;

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

}
