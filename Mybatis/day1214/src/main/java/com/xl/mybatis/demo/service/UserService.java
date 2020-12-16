package com.xl.mybatis.demo.service;

import com.xl.mybatis.demo.dao.userMapper;
import com.xl.mybatis.demo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserService {
//    mybatis dao层代理实现  不需要写接口的实现
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        User user = mapper.findById(24);
        System.out.println(user);
    }
}
