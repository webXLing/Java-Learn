package download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class DlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取文件名
        String name = request.getParameter("name");
            //1.1 获取文件的绝对路径
        ServletContext servletContext = this.getServletContext();

        String realPath = servletContext.getRealPath("/images/" + name);

//        servletContext.getRealPath
           // 在web 资源下 直接 /
            // 在src 下自配置文件会最终 在WEB-INF 下的 classes 中 所以 /WEB-INF/classes


        System.out.println(realPath);
            //1.2 设置响应头
        String mimeType = servletContext.getMimeType(name);
        response.setContentType(mimeType); //设置mime

        // 设置响应头打开方式
        response.setHeader("content-disposition","attachment;filename="+name);


        //2、使用字节输入是文件加载到内存
        FileInputStream is = new FileInputStream(realPath);

        //3.输出
        ServletOutputStream outputStream = response.getOutputStream();
            //使用缓冲区 加快读取
        byte[] bytes = new byte[1024 * 8];
        int len = 0;

        while ((len = is.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }

        is.close(); //释放资源
    }
}
