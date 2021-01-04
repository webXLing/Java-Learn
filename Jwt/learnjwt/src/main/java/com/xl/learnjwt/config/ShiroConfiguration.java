package com.xl.learnjwt.config;


import com.xl.learnjwt.utils.CustomRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfiguration {
//    1.创建realm
    // 方法名可以自定义
    @Bean
    public CustomRealm getCustomRealm(){
        return new CustomRealm();
    }

    // 2 .创建安全管理器
    @Bean
    public SecurityManager getSecurityManager(CustomRealm realm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager(realm);
        return manager;
    }
    // 3.配置shiro过滤器工厂
    // - shiro 通过一组过滤器 来控制权限
    @Bean
    public ShiroFilterFactoryBean filterFactory ( SecurityManager manager){
        // 1.创建工厂
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 2.设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(manager);
        // 3.通用设置 未授权 跳转错误页 登录成功跳转登录页
        shiroFilterFactoryBean.setLoginUrl("/author?code=1");
        shiroFilterFactoryBean.setUnauthorizedUrl("/author?code=2");

        // 4.设置过滤器集合
        /**
         * 过滤器集合 有顺序的map
         * key 拦截的路径
         * value 过滤器类型
         * anno    ：匿名访问（表明此链接所有人可以访问）
         * authc   ：认证后访问（表明此链接需登录认证成功之后可以访问）
         * "perms[user-home]"  具有user-home 权限才可以访问
         * roles[系统管理员]
         */
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        // map.put("/user/home","anon"); // 匿名登录
        map.put("/user/home","perms[user-home]");// 具有user-home 权限才可以访问
        map.put("/user/home","roles[系统管理员]");// 具有系统管理员 的角色 才可以访问
        //认证之后访问（登录之后可以访问）
        map.put("/user/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //配置shiro注解支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        System.out.println("shiro 支持注解");
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}
