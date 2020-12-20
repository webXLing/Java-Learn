package com.xl.mybatis.demo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.mybatis.demo.dao.userMapper;
import com.xl.mybatis.demo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMapper {
    @Test
    public void test1() throws IOException {
        User user = new User();
//        user.setName("xl");
//        user.setAge(24);
        user.setId(14);
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper mapper = sqlSession.getMapper(userMapper.class);

        List<User> byCondition = mapper.findByCondition(user);
        System.out.println(byCondition );

    }

    @Test
    public void test2() throws IOException {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(24);
        ids.add(8);
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper mapper = sqlSession.getMapper(userMapper.class);

        List<User> byCondition = mapper.findByIds(ids);
        System.out.println(byCondition );
    }

    @Test
    public void test3() throws IOException {
        User user = new User();
        user.setName("ceshi");
        Date date = new Date();
        System.out.println("date"+date);
        user.setBirthday(date);
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        mapper.setUserBirthday(user);

    }

    @Test
    public void test4() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper mapper = sqlSession.getMapper(userMapper.class);

        Page page = PageHelper.startPage(1, 2);
        List<User> myAll = mapper.findMyAll();
        for (User user:myAll){
            System.out.println(user);

        }
    }


}
