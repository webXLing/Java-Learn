package com.xl.learnjwt.dao;

import com.xl.learnjwt.entity.PeUser;
import com.xl.learnjwt.entity.TestUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeUserMapper {
    PeUser getByName(String name);
}
