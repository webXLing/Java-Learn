package com.xl.learnjwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    private  static  final String SING = "#@!%$%#$asda32143";

    /**
     * 生成token
     */
    public static String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,7);
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        String token = builder
                .withExpiresAt(instance.getTime()) // 100s后过期
                .sign(Algorithm.HMAC256(SING));// 设置延签

        return token;
    }

    /**
     * 检验token
     */
    public static DecodedJWT verify(String token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SING)).build();
        return  jwtVerifier.verify(token);
    }
}
