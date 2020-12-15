package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/GetCodeServlet")
public class GetCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.生成图片
        int width = 100;
        int height = 50;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        Graphics g = img.getGraphics(); // 画笔对象
        g.setColor(Color.pink);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.blue);
        g.drawRect(0, 0, width - 1, height - 1);

        String str = "dasdsafagfafafagwgwifh23423r42";

        Random random = new Random();

        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            g.drawString(str.charAt(index) + "", width / 4 * i, 15);
        }

        g.setColor(Color.green);
        for (int i = 0; i < 4; i++) {
            int i1 = random.nextInt(width);
            int i2 = random.nextInt(width);
            int i3 = random.nextInt(height);
            int i4 = random.nextInt(height);
            g.drawLine(i1, i2, i3, i4);
        }

        //3、将图片输出
        ImageIO.write(img, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
