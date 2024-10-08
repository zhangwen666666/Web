package com.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajaxrequest2")
public class AjaxRequest2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // out.print("<font color='blue'>欢迎学习AJAX</font>");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        out.print("<h1>欢迎"+username+"登录<a href='https://www.baidu.com'>点击给你看点好东西</a></h1><br>");
        out.print("密码：" + password);
    }
}
