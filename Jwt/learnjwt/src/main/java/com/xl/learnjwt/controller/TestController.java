package com.xl.learnjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @GetMapping("/test/test")
    public Object test(String username, HttpServletRequest request){
        // 认证成功 放入session
        request.getSession().setAttribute("username",username);
        return "login res";

    }
}
