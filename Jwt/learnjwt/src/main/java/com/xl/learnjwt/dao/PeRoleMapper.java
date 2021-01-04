package com.xl.learnjwt.dao;

import com.xl.learnjwt.entity.PeRole;
import com.xl.learnjwt.entity.PeUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PeRoleMapper {
    List<PeRole> getListByUid(String id);
}
