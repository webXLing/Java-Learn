package com.xl.learnjwt.utils;

import com.xl.learnjwt.entity.PePermission;
import com.xl.learnjwt.entity.PeRole;
import com.xl.learnjwt.entity.PeUser;
import com.xl.learnjwt.service.PeRoleService;
import com.xl.learnjwt.service.PeUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private PeUserService peUserService;

    @Autowired
    private PeRoleService peRoleService;


    public void setName(String name){
        super.setName("customRealm");
    }

    @Override
    /**
     * 授权
     * 查看该用户是否有权限
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("查看该用户是否有权限");
        // 1 获取已登录的用户
        PeUser user =(PeUser)  principalCollection.getPrimaryPrincipal();
        // 2 获取设置 用户的 角色 和权限
        Set<String> roles = new HashSet<>();
        Set<String> pers = new HashSet<>();

        user.getRoles().stream().forEach(role->{
            roles.add(role.getName());
        });
        user.getPermissionList().stream().forEach(per->{
            pers.add(per.getCode());
        });
        System.out.println("roles"+roles);
        System.out.println("pers"+pers);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(pers);
        return info;
    }

    /**
     * 登录
     * //认证：认证的主要目的，比较用户名和密码是否与数据库中的一致
     * //将安全数据存入到shiro进行保管
     * //参数：authenticationToken登录构造的usernamepasswordtoken
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("登录");

        // 1.获取登录的 账号密码（token）
        UsernamePasswordToken token  = (UsernamePasswordToken) authenticationToken;

        // 2. 通过用户名获取数据库中的用户
        String username = token.getUsername();
        String  password = new String(token.getPassword());
        // 数据库中的密码是加密的 密码+盐+次数
//        password = new Md5Hash(password, username, 3).toString();
        PeUser user = peUserService.getByName(username);
        List<PeRole> peRoleList = peRoleService.getListByUid(user.getId());
        System.out.println("peRoleList"+peRoleList);
        user.setRoles(peRoleList); // 角色  张三
        PePermission pePermission1 = new PePermission();
        pePermission1.setId("1");
        pePermission1.setName("添加用户");
        pePermission1.setCode("user-add");

        PePermission pePermission2 = new PePermission();
        pePermission2.setId("2");
        pePermission2.setName("查询用户");
        pePermission2.setCode("user-find");

//        PePermission pePermission3 = new PePermission();
//        pePermission3.setId("5");
//        pePermission3.setName("用户主页");
//        pePermission3.setCode("user-home");
        List<PePermission> pePermissions = new ArrayList<>();
        pePermissions.add(pePermission1);
        pePermissions.add(pePermission2);
//        pePermissions.add(pePermission3);
        user.setPermissionList(pePermissions);
        System.out.println("setPermissionList"+user.getPermissionList());
        // 3.检验密码
        System.out.println(user.getPassword()+"---data---"+password);
        System.out.println(user.getPassword().equals(password));
        if(user.getPassword().equals(password)){
            // 4.如果正确 则返回安全数据
            // 构造方法:安全数据，密码，realm域名
            System.out.println(1);
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
            System.out.println(2);

            return simpleAuthenticationInfo;
        }else{

        }
        // 5.否则异常
        return null;
    }
}
