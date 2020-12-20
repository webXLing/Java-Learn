package com.xl.mybatis.demo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.mybatis.demo.dao.userMapper;
import com.xl.mybatis.demo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TesyAno {
    private userMapper mapper;

    @Before
    public void bore() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(userMapper.class);

    }


    @Test
    public void  test11(){
        List<User> users = mapper.selectAndRoleAno();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void  test10(){
        List<User> users = mapper.selectAndOrderAno();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void  test(){
        List<User> users = mapper.selectAno();
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void  tes1(){
        User user = new User();
        user.setName("1220");
        user.setId(10);
        mapper.updateAno(user);
        System.out.println(user);
    }


    @Test
    public void  tes2(){
        mapper.deleteAno(13);
    }


    @Test
    public void  tes3(){
        User user = new User();
        user.setName("1220");
        user.setBirthday(new Date());
        user.setAge(23);
        user.setMoney(213);
        mapper.inserAno(user);
        System.out.println(user);
    }
}
