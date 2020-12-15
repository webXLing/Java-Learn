package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/getInfo")
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        获取post 数据
         */
        BufferedReader reader = request.getReader();
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        获取请求方法 GET
         */
        String method = request.getMethod();
        System.out.println(method);

        /*
        获取获取虚拟目录 /servlet3
         */
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        /*
        获取servlet 路径 /getInfo
         */
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        /*
        获取URI 统一资源标识符 /servlet3/getInfo
         */
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        /*
        获取URL 统一资源定位符 http://localhost:7070/servlet3/getInfo
         */
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);

        /*
        获取协议和 版本  HTTP/1.1
         */
        String protocol = request.getProtocol();
        System.out.println(protocol);

        /*
        获取客户的ip 0:0:0:0:0:0:0:1
         */
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);

    }
}
