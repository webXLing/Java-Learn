package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");// 避免表单数据 中文乱码

        //1.5 校验验证码
        String verifycode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER"); // 确保一次验证码只能用一次

        if(checkcode_server.equalsIgnoreCase(verifycode)){//验证码正确
            //2.获取数据 会参
            Map<String, String[]> parameterMap = request.getParameterMap();

            //3.分装User
            User user = new User();
            try {
                BeanUtils.populate(user,parameterMap); //是 阿帕奇的包 注意

                //4.调用service 去 查询
                UserService userService = new UserServiceImpl();
                User login = userService.login(user);
                if(login!=null){//登录成功
                    session.setAttribute("user",login);
                    //用不到request 域 数据 所以直接用 重定向
                    response.sendRedirect(request.getContextPath()+"/index.jsp");
                }else{
                    //登录失败
                    request.setAttribute("login_err","用户名或密码错误");
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }else{//验证码失败 转发 login.jsp
            request.setAttribute("login_err","验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }




        //3.分装User


        //5.判断是否成功



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
