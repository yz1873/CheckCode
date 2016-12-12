package com.servlet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
@javax.servlet.annotation.WebServlet(name = "ImageServlet",urlPatterns="/servlet/ImageServlet")
public class ImageServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        BufferedImage bi = new BufferedImage(68,22,BufferedImage.TYPE_INT_RGB); //图像宽度68，高度22,图片类型为BufferedImage.TYPE_INT_RGB
        Graphics g = bi.getGraphics();
        Color c = new Color(200,150,255);//设置颜色
        g.setColor(c);                   //g设置颜色
        g.fillRect(0,0,68,22);           //图片设置边框

        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray(); //设置字符集
        Random r = new Random();
        int len = ch.length;
        int index;
        StringBuffer sb = new StringBuffer(); //保存生成的字符
        for (int i = 0;i < 4;i++){
            index = r.nextInt(len);//该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n
            g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255))); //为每个字体随机设置一个颜色
            g.drawString(ch[index]+"",(i*15)+3,18);//str - 参数为（要绘制的string,x坐标,y 坐标）
            sb.append(ch[index]);
        }
        request.getSession().setAttribute("piccode",sb.toString()); //将字符存在session中，用于后面的比较
        ImageIO.write(bi,"JPG",response.getOutputStream()); //将图像输出
    }
}
