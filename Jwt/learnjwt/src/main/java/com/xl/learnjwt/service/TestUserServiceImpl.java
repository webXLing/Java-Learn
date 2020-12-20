package com.xl.learnjwt.service;

import com.xl.learnjwt.dao.UserMapper;
import com.xl.learnjwt.entity.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestUserServiceImpl implements TestUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public TestUser loginSvc(TestUser user) {
        // 查询数据库
        TestUser testUser = userMapper.login(user);
        if(testUser!=null){
            return testUser;
        }
        throw  new RuntimeException("查无此人");
    }
}
