package servlet;

import Dao.UserDao;
import cn.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
//        设置编码
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("rishi");
            e.printStackTrace();
        }
//        获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        User loginUser = new User();
        loginUser.setPassword(password);
        loginUser.setUsername(username);
        System.out.println(loginUser);

        UserDao userDao = new UserDao();
        System.out.println(111);;
        User user = userDao.login(loginUser);

//        User user = userDao.login(loginUser); // 数据库中查询的 user 结果

        System.out.println(1111);
        if (user==null) {
            //登录失败  转发
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/failServlet");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("22222");
                e.printStackTrace();
            }
        }else{
            //登录成功
            request.setAttribute("user",user);

            try {
                request.getRequestDispatcher("/successServlet").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
