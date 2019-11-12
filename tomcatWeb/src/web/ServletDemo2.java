package web;

import javax.servlet.*;
import java.io.IOException;

/*
servlet
 */
public class ServletDemo2 implements Servlet {

    /**
     * 方法
     * servlet 被创建时执行 一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("请求了我");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器关闭时 执行一次
     */
    @Override
    public void destroy() {
        System.out.println("...destroy");
    }
}
