package uploadFile;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

// 客户端上传文件 到服务器
public class Client {
    public static void main(String[] args) throws IOException {
        // 本地字节输入流
        FileInputStream fis = new FileInputStream("/Users/xl/Downloads/BG (1).png");

        Socket socket = new Socket("127.0.0.1", 8889);

        OutputStream os = socket.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
//        读取本地文件
        while ((len = fis.read(bytes)) != -1) {
//            上传服务器
            os.write(bytes, 0, len);
        }

        InputStream is = socket.getInputStream();
//        获取服务器的回参数

        while ((len = is.read(bytes)) != -1) {
//            上传服务器
            System.out.println(new String(bytes, 0, len));
        }

//        释放资源
        fis.close();
        socket.close();
    }

}

