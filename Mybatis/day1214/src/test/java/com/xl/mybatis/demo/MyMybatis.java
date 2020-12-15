package com.xl.mybatis.demo;

import com.xl.mybatis.demo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyMybatis {
    @Test
    public void test() throws IOException {
        // 获取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        // 获取session 工厂对象
        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // session 回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 那条sql namespace + id
        List<User> objects = sqlSession.selectList("userMapper.findMyAll");
        System.out.println(objects);

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void test1() throws IOException {
        User user = new User();
        user.setAge(26);
        user.setName("xlwe");
        user.setMoney(4213);
        // 获取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        // 获取session 工厂对象
        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // session 回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        // 那条sql namespace + id
        int insert = sqlSession.insert("userMapper.create", user);
        System.out.println(insert);
//        Mybatis 事务默认不提交
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }
    //    修改
    @Test
    public void test2() throws IOException {
        User user = new User();
        user.setId(10);
        user.setName("newname");
        user.setMoney(4213);
        // 获取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        // 获取session 工厂对象
        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // session 回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        // 那条sql namespace + id
        int insert = sqlSession.update("userMapper.update", user);
        System.out.println(insert);
    //        Mybatis 事务默认不提交
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    //    删除
    @Test
    public void test4() throws IOException {
        User user = new User();
        user.setId(11);
        user.setName("newname");
        user.setMoney(4213);
        // 获取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        // 获取session 工厂对象
        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // session 回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        // 那条sql namespace + id
        int insert = sqlSession.delete("userMapper.delete", user);
        System.out.println(insert);
        //        Mybatis 事务默认不提交
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }
}
