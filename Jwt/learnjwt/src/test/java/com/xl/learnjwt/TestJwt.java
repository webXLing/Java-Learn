package com.xl.learnjwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xl.learnjwt.entity.PeUser;
import com.xl.learnjwt.entity.TestUser;
import com.xl.learnjwt.service.PeUserService;
import com.xl.learnjwt.service.TestUserService;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import sun.util.resources.CalendarData;

import java.util.Calendar;

public class TestJwt {

    @Autowired
    private PeUserService peUserService;

    @Autowired
    private TestUserService testUserService;

    @Test
    // 生成token
    public  void  test(){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,100);


        String token = JWT.create()
                .withClaim("userId", 1)
                .withClaim("username", "xl")
                .withExpiresAt(instance.getTime()) // 100s后过期
                .sign(Algorithm.HMAC256("#@!%$%#$asda32143"));// 设置延签

        System.out.println(token);
    }
    // 检验token
    @Test
    public  void test1(){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("#@!%$%#$asda32143")).build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoieGwiLCJleHAiOjE2MDkxNzEyNTksInVzZXJJZCI6IjEifQ.5zRSNgaTcQnCW7LkvYlDlkJAoT8YikaW26oHQZmW8Y4");
        String userId = verify.getClaim("userId").asString();
        String username = verify.getClaim("name").asString();
        System.out.println(userId+""+username);
    }

    @Test
    public void  test2(){
//        PeUser zhangsan = peUserService.getByName("zhangsan");
//        System.out.println(zhangsan);
        TestUser testUser = new TestUser();
        testUser.setPassword("123456");
        testUser.setUsername("xl");
        TestUser testUser1 = testUserService.loginSvc(testUser);
        System.out.println(testUser1);
    }

    @Test
    public  void test3(){
        TestUser testUser = new TestUser();
        testUser.setPassword("123456");
        testUser.setUsername("xl");
        TestUser testUser1 = testUserService.loginSvc(testUser);
        System.out.println(testUser1);
    }
}
