package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/cookie/generate"})
public class GenerateCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 创建cookie对象
        Cookie cookie = new Cookie("productid", "123889789223471");
        Cookie cookie1 = new Cookie("zhangsan", "123456");
        // 设置cookie在一小时之后失效
        // cookie.setMaxAge(60 * 60);
        cookie.setMaxAge(-1);
        cookie1.setMaxAge(-1);
        cookie.setPath(request.getContextPath());
        cookie1.setPath(request.getContextPath());
        // 将cookie对象响应到浏览器
        response.addCookie(cookie);
        response.addCookie(cookie1);
    }
}
