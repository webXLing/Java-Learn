package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用dao
        return dao.findAll();
    }

    /*
        通过用户名 和密码查询用户
     */
    @Override
    public User login(User user) {
        return dao.getUserByUsername(user.getUsername(),user.getPassword());
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    /**
     * 通过id  查询用
     * @param id
     */
    @Override
    public User findUser(String id) {
       return dao.findUser(Integer.parseInt(id));
    }

    /**
     * 修改user数据
     * @param user
     */
    @Override
    public void updataUser(User user) {
        dao.updataUser(user);
    }

    /**
     * deleteSelect 删除一组数据
     */
    @Override
    public void deleteSelect(String [] ids) {
        for (String id : ids) {
            dao.delete(id);
        }

    }

    public void addUser(User user){
        dao.addUser(user);
    }
}
