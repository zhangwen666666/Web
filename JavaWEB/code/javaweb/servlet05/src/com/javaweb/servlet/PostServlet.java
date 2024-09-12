package com.javaweb.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class PostServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        // 响应一些内容到浏览器上。
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<!doctype html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <title>from post servlet</title>");
        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1>from post servlet</h1>");
        out.print("    </body>");
        out.print("</html>");
    }
}
