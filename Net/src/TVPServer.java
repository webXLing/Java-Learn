import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    TCP 服务器 ： 接收客户端发送的请求 向客户端发送数据
    java.net.ServerSocket 实现服务器的套接字
 */
public class TVPServer {
    public static void main(String[] args) throws IOException {
//        1.创建ServerSocket 对象 并向系统获取 指定端口
        ServerSocket server = new ServerSocket(8888);
        //2 获取请求的客户端
        Socket accept = server.accept();

//       3.通过socket 客户端对象获取网络字节输入流 读取客户端发送的数据
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        len = inputStream.read(bytes);
        System.out.println(len);

        System.out.println(new String(bytes, 0, len));
//        while ((len=inputStream.read(bytes))!=-1){ //读取客户端发送的数据
//            System.out.println(1);
//            System.out.println(new String(bytes,0,len));
//        }
//        System.out.println(11);
//        4.向客户端 会写数据
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("我是服务器，我收到了".getBytes());

//        关闭流 关闭服务器
        accept.close();
        server.close();
    }
}
