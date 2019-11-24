package web.filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter( "/*")
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 强转
        HttpServletRequest request = (HttpServletRequest) req;

        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        System.out.println(request.getRequestURL());

        if(requestURI.contains("login.jsp")
                ||requestURI.contains("/checkCodeServlet")
                ||requestURI.contains("/loginServlet")
                ||requestURI.contains("/css/")
                ||requestURI.contains("/js/")
                ||requestURI.contains("/font/")){
            chain.doFilter(req, resp);

        }else{
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if (user != null) {//没有登录
                chain.doFilter(req, resp);
            }else{
                request.setAttribute("login_err","你还没登录哦!");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
