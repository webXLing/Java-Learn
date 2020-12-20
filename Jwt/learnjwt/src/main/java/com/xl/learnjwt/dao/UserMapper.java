package com.xl.learnjwt.dao;

import com.xl.learnjwt.entity.TestUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    TestUser login(TestUser user);
}
