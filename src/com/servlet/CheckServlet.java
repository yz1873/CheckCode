package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/12/11 0011.
 */
@WebServlet(name = "CheckServlet",urlPatterns="/servlet/CheckServlet")
public class CheckServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String piccode   = (String)request.getSession().getAttribute("piccode");//取得图片中的字符串
        String checkcode = request.getParameter("checkcode");                   //取得用户输入的字符串
        checkcode = checkcode.toUpperCase();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out  = response.getWriter();     //做一个输出流
        if (checkcode.equals(piccode)){
            out.println("验证码输入正确！");
        }
        else {
            out.println("验证码输入错误！");
        }
        out.flush();
        out.close(); //关闭输出流
    }
}
