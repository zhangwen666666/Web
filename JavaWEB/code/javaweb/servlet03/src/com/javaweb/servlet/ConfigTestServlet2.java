package com.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ConfigTestServlet2 extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        // 获取ServletConfig对象
        jakarta.servlet.ServletConfig config = this.getServletConfig();
        writer.print("ServletConfig对象是：" + config);
    }
}
