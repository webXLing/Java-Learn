import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
    TCP 客户端 ： 向服务器发送链接请求 向服务器发送数据 读取服务器回写数据
    java.net.Socket 包换端口和ip地址的对象
 */
public class TVPClient {
    public static void main(String[] args) throws IOException {
//        1.创建一个客户端对象 Socket 绑定ip 和端口
        Socket socket = new Socket("127.0.0.1", 8888);
//        2.通过socket 客户端对象获取网络字节输出流
        OutputStream outputStream = socket.getOutputStream();

        // 3.通过write方法 向服务器放松数据
        outputStream.write("你好服务器".getBytes());

//        4.通过字节输入流获取 服务器响应的数据
        InputStream inputStream = socket.getInputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));
//        while ((len=inputStream.read(bytes))!=-1){
//            System.out.println(new String(bytes,0,len));
//        }
//        关闭流
        socket.close();
    }
}
