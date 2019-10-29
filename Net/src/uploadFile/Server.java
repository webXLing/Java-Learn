package uploadFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 服务器 获取上传的文件 存在服务器上
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8889);
        
//        通过accept 方法 获取请求的socket对象

        Socket accept = serverSocket.accept();

        //获取网络字节输入流
        InputStream is = accept.getInputStream();

//        判断存放图片的目录是否存在  不存在则 创建
        File filePath = new File("Net/img");
        if(filePath.exists()){
            filePath.mkdir();
        }

        //保存文件
        FileOutputStream os = new FileOutputStream(filePath+"/1.png");
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len=is.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
//        回参数
        accept.getOutputStream().write("上传成功".getBytes());

        os.close();
        accept.close();
        serverSocket.close();


    }
}
