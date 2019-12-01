package com.epochong.servlet;

import com.epochong.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding ("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        if (userService.userLogin(username, password)) {
            out.write("<script>\n" +
                    "    alert(\"登陆成功\")\n" +
                    "        window.location.href = \"/login.html\";\n" +
                    "    </script>");
        } else {
            out.write("<script>\n" +
                    "    alert(\"用户名或密码错误，如果没有账号请注册\")\n" +
                    "        window.location.href = \"/register.html\";\n" +
                    "    </script>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
