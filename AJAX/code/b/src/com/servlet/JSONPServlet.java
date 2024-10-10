package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jsonp1")
public class JSONPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // System.out.println("jsonp完成跨域访问");
        // 向前端响应一段js代码
        PrintWriter out = response.getWriter();
        // out.print("alert(123)");
        // out.print("sayHello()");
        // 响应一段js代码，传一个json数据给前端
        // out.print("sayHello({\"name\":\"jackson\"})");
        // 动态获取前端传过来的函数名
        String fun = request.getParameter("fun");
        out.print(fun + "({\"name\":\"jackson\"})");
    }
}
