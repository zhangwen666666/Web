package com.javaweb.servlet;
import jakarta.servlet.*;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class AServlet implements Servlet {
    public AServlet() {
        System.out.println("AServlet 无参数构造方法执行了");
    }


//    public AServlet(String s) {
//    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("AServlet init method execute");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("AServlet service method execute");
    }

    @Override
    public void destroy() {
        System.out.println("AServlet destroy method execute");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

}
