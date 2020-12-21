package com.xl.learnjwt.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Map<String,Object> claims;
    protected String userId;
    protected String username;


    @ModelAttribute
    public void setResAndResp(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
//        DecodedJWT user_claims =(DecodedJWT) request.getAttribute("user_claims");
        String userId = (String) request.getAttribute("userId");
        String username1 = (String) request.getAttribute("username");
        if(userId!=null){
            this.username = username1;
            this.userId = userId;
        }

    }
}
