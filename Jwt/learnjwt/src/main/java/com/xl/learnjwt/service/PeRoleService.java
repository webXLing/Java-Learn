package com.xl.learnjwt.service;

import com.xl.learnjwt.dao.PeRoleMapper;
import com.xl.learnjwt.dao.PeUserMapper;
import com.xl.learnjwt.entity.PeRole;
import com.xl.learnjwt.entity.PeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeRoleService {
    @Autowired
    private PeRoleMapper peRoleMapper;

   public List<PeRole> getListByUid(String id){
       List<PeRole> listByUid = peRoleMapper.getListByUid(id);
       return  listByUid;
   }
}
