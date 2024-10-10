package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jsonp3")
public class JSONPServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取函数名
/*        String callback = request.getParameter("callback");
        // 响应一段js代码
        PrintWriter out = response.getWriter();
        // out.print("({\"username\": \"张三\"})");
        out.print(callback + "({\"username\": \"张三\"})");*/

        String fun = request.getParameter("fun");
        // 响应一段js代码
        PrintWriter out = response.getWriter();
        out.print(fun + "({\"username\": \"张三\"})");
    }
}
