package com.xl.mybatis.demo;

import com.xl.mybatis.demo.dao.OrderMapper;
import com.xl.mybatis.demo.dao.RoleMapper;
import com.xl.mybatis.demo.entity.Order;
import com.xl.mybatis.demo.entity.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TesyAno3 {
    private RoleMapper mapper;

    @Before
    public void bore() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("slqConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(RoleMapper.class);

    }

    @Test
    public void  test(){
        List<Role> byUid = mapper.findByUid(14);
        for (Role order : byUid) {
            System.out.println(order);
        }
    }



}
