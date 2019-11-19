package service;

import domain.User;

import java.util.List;

/*
用户管理的 业务接口
 */
public interface UserService {
    /**
     * 查询所有的用户
     * @return
     */
    public List<User> findAll();

    public User login(User user);

    /**
     * 根据id 删除
     */
    void delete(String id);

    /**
     * 通过id 查询用户
     * @param id
     */
     User findUser(String id);

    void updataUser(User user);

    /**
     * 删除一组数据
     */
    void deleteSelect(String [] ids);
}
