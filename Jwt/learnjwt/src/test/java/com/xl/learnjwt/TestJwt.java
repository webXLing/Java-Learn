package com.xl.learnjwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import sun.util.resources.CalendarData;

import java.util.Calendar;

public class TestJwt {

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
}
