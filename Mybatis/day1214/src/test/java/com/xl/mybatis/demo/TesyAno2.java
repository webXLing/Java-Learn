package com.xl.mybatis.demo;

import com.xl.mybatis.demo.dao.OrderMapper;
import com.xl.mybatis.demo.dao.userMapper;
import com.xl.mybatis.demo.entity.Order;
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

public class TesyAno2 {
    private OrderMapper mapper;

    @Before
    public void bore() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(OrderMapper.class);

    }

    @Test
    public void  test(){
        List<Order> orders = mapper.myFindAllAno();
        for (Order order : orders) {
            System.out.println(order);
        }
    }


    @Test
    public void  test2(){
        List<Order> orders = mapper.myFindAllAno2();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

}
