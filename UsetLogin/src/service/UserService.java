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
}
