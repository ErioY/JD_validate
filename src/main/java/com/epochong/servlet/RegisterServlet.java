package com.epochong.servlet;

import com.epochong.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        String code = request.getParameter("confirm");
        String email = request.getParameter("email");

        if (userService.userRegister(username,password)) {
            /*
             * 用户注册成功，弹窗提示
             * 返回登录界面
             */
            writer.println("<script>\n" +
                    "    alert(\"注册成功\");\n" +
                    "    window.location.href = \"/login.html\" ;\n" +
                    "</script>");
        } else {
            /*弹框失败，保留原页面*/
            writer.println("<script>\n" +
                    "    alert(\"注册失败,该账户已存在\");\n" +
                    "    window.location.href = \"/register.html\" ;\n" +
                    "</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
