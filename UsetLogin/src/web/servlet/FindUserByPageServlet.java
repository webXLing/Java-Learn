package web.servlet;

import domain.PageBean;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取请求参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage==null|| currentPage==""){
            currentPage = "1";
        }

        if(rows==null|| rows==""){
            rows = "3";
        }

        // 1.1 获取map 参数
        Map<String, String[]> condition = request.getParameterMap();

        //2.调用service 查询 pagebeen

        UserService userService = new UserServiceImpl();
        PageBean<User> pb =  userService.findUserByPage(currentPage,rows,condition);




        //3.将PageBean 传入request
        request.setAttribute("pb",pb);
        System.out.println(pb);

        //4.展示list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
