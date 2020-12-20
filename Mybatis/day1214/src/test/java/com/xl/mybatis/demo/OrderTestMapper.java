package com.xl.mybatis.demo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.mybatis.demo.dao.OrderMapper;
import com.xl.mybatis.demo.dao.userMapper;
import com.xl.mybatis.demo.entity.Order;
import com.xl.mybatis.demo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrderTestMapper {
    @Test
    public void test() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> all = mapper.myFindAll();
//        Page page = PageHelper.startPage(1, 2);
//        List<User> myAll = mapper.findMyAll();
        for (Order order:all){
            System.out.println(order);

        }
        sqlSession.close();
    }
    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper mapper = sqlSession.getMapper(userMapper.class);

        List<User> myAll = mapper.selectUserOrder();
        for (User user:myAll){
            System.out.println(user);

        }
    }

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper mapper = sqlSession.getMapper(userMapper.class);

        List<User> myAll = mapper.selectUserRole();
        for (User user:myAll){
            System.out.println(user);

        }
    }


}
