package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

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
        return dao.getUserByUsername(user.getUsername(), user.getPassword());
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    /**
     * 通过id  查询用
     *
     * @param id
     */
    @Override
    public User findUser(String id) {
        return dao.findUser(Integer.parseInt(id));
    }

    /**
     * 修改user数据
     *
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
    public void deleteSelect(String[] ids) {
        for (String id : ids) {
            dao.delete(id);
        }

    }

    /**
     * 分页查询
     *
     * @param _currentPage
     * @param _rows
     * @param condition
     * @return
     */
    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage); // 当前页码
        int rows = Integer.parseInt(_rows); // 每页数量

        //1.创建空的 对象
        PageBean<User> userPageBean = new PageBean<>();

        userPageBean.setCurrentPage(currentPage);
        userPageBean.setRows(rows);

        //2。调用 dao 查询总记录数
        int totalCount = dao.findTotalCount(condition);
        userPageBean.setTotalCount(totalCount);
        float res = totalCount / rows;
        System.out.println(res);
        int totalPage = (int) Math.ceil(res);
        System.out.println(totalCount);
        System.out.println(rows);
        userPageBean.setTotalCPage(totalPage);

        //3.获取某一页的数据
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows, condition);
        userPageBean.setList(list);

        return userPageBean;
    }

    public void addUser(User user) {
        dao.addUser(user);
    }
}
