package com.xl.learnjwt.interceptors;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xl.learnjwt.utils.JWTUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * jwt 拦截器
 * 1. 通过request 获取 token
 * 2.通过解析token 获取claims (存储的用户信息)
 * 3.将claims 绑定到request 域当中去
 */
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        HashMap<String, Object> map = new HashMap<>();

        try {
            DecodedJWT decodedJWT = JWTUtils.verify(token);//验证令牌
            String userId = decodedJWT.getClaim("userId").asString();
            String username = decodedJWT.getClaim("name").asString();
            System.out.println("#!@#!@#!@#@!"+userId);
            request.setAttribute("userId",userId);
            request.setAttribute("username",username);
            return true;
        }catch (Exception e){
            map.put("state",false);
            map.put("msg",e.getMessage()+"无效token");
            // 使用jackson
            String s = new ObjectMapper().writeValueAsString(map);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println(s);
        }
        return false;
    }
}
