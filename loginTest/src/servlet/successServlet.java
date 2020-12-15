package servlet;

import cn.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class successServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取 request 域 的共享数据
        User user = (User) request.getAttribute("user");
//        Object user = request.getAttribute("user");
        //返回响应
        response.setContentType("text/html;charset=utf-8");

        response.getWriter().write("登录成功" + user.getUsername() + "欢迎您");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
