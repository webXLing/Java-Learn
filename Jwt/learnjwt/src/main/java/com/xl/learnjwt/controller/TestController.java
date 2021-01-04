package com.xl.learnjwt.controller;

import com.xl.learnjwt.entity.PeRole;
import com.xl.learnjwt.entity.PeUser;
import com.xl.learnjwt.service.PeRoleService;
import com.xl.learnjwt.service.PeUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private PeUserService peUserService;

    @Autowired
    private PeRoleService peRoleService;

    @GetMapping("/test/test")
    public Object test(String username, HttpServletRequest request){
        // 认证成功 放入session
        request.getSession().setAttribute("username",username);
        return "login res";

    }

    @GetMapping("/user")
    public PeUser user(String username){

        PeUser zhangsan = peUserService.getByName(username);
//        System.out.println(zhangsan);
        return zhangsan;
    }

    @GetMapping("/user/rolelist")
    public List<PeRole> userRoleList(String id){
        List<PeRole> listByUid = peRoleService.getListByUid(id);

        return listByUid;
    }


    @GetMapping("/author")
    public String testAuthor(int code){
        if(code==1){
            return "未登录";
        }else{
            return "未授权";
        }
    }

    @GetMapping("/user/home")
    public String testAuthor1(){
        return "登录成功 user/home";
    }

    //使用shiro注解鉴权
    //@RequiresPermissions()  -- 访问此方法必须具备的权限
    //@RequiresRoles() -- 访问此方法必须具备的角色

    /**
     * 1.过滤器：如果权限信息不匹配setUnauthorizedUrl地址
     * 2.注解：如果权限信息不匹配，抛出异常
     */

    @RequiresPermissions("user-add") // 必须具有该权限
    @GetMapping("/user/add")
    public String testAuthor22 (){
        return "添加用户成功";
    }

    @RequiresPermissions("user-update") // 必须具有该权限
    @GetMapping("/user/update")
    public String testAuthor2 (){
        return "编辑用户成功";
    }

    // 权限 基于注解 改用户未有这个权限 则会抛出异常
    @RequiresRoles("系统管理员") // 必须具该角色
    @GetMapping("/user/find")
    public String testAuthor33 (){
        return "查询用户成功";
    }

    @RequiresRoles("普通员工") // 必须具该角色
    @GetMapping("/user/delete")
    public String testAuthor3 (){
        return "删除用户成功";
    }



    /**
     *  1.传统登录
     *      前端发送登录请求 => 接口部分获取用户名密码 => 程序员在接口部分手动控制
     *  2.shiro登录
     *      前端发送登录请求 => 接口部分获取用户名密码 => 通过subject.login =>  realm域的认证方法
     *
     */
    //用户登录
    @GetMapping("/login/shiro")
    public String login(String username,String password) {
        //构造登录令牌
        try {

            /**
             * 密码加密：
             *     shiro提供的md5加密
             *     Md5Hash:
             *      参数一：加密的内容
             *              111111   --- abcd
             *      参数二：盐（加密的混淆字符串）（用户登录的用户名）
             *              111111+混淆字符串
             *      参数三：加密次数
             *
             */
            password = new Md5Hash(password,username,3).toString();
            System.out.println(password+"---password");
            UsernamePasswordToken upToken = new UsernamePasswordToken(username,password);
            //1.获取subject
            Subject subject = SecurityUtils.getSubject();

            //获取session
//            String sid = (String) subject.getSession().getId();

            //2.调用subject进行登录
            subject.login(upToken);
            return "登录成功";
        }catch (Exception e) {
            System.out.println(e);
            return "用户名或密码错误";
        }
    }
}
