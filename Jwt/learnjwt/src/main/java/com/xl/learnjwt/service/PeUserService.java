package com.xl.learnjwt.service;

import com.xl.learnjwt.dao.PeUserMapper;
import com.xl.learnjwt.entity.PeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeUserService {
    @Autowired
    private PeUserMapper peUserMapper;

   public PeUser getByName(String name){
       PeUser byName = peUserMapper.getByName(name);
       if(byName!=null){
           return byName;
       }
       throw  new RuntimeException("查无此人");
   }
}
