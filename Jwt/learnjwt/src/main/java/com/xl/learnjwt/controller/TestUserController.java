package com.xl.learnjwt.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.xl.learnjwt.entity.TestUser;
import com.xl.learnjwt.service.TestUserService;
import com.xl.learnjwt.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestUserController extends BaseController{

    @Autowired
    private TestUserService testUserService;

    @GetMapping("/login")
    public Map<String,Object> login(TestUser testUser){
        HashMap<String, Object> map = new HashMap<>();

        try {
            TestUser testUser1 = testUserService.loginSvc(testUser);
            HashMap<String, String> map1 = new HashMap<>();
            Integer id = testUser1.getId();
            map1.put("userId",id.toString());
            map1.put("name",testUser1.getUsername());
            String token = JWTUtils.getToken(map1);
            map.put("state",true);
            map.put("msg","登录成功");
            map.put("token",token);
        }catch (Exception e){
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }


    @GetMapping("/test")
    public Map<String,Object> test(String token, HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();

        map.put("msg","秦秋成功成功");
        map.put("data",this.userId );

        return map;
    }
}
