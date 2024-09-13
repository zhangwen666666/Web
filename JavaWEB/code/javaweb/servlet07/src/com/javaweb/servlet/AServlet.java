package com.javaweb.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 向request域中绑定数据。
        request.setAttribute("sysTime", new Date());

        // 从request域中取出数据
        Object obj = request.getAttribute("sysTime");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("A中request域中获取的系统当前时间: " + obj + "<br>");

        // 在AServlet中new一个BServlet对象，然后调用BServlet对象的doGet方法，把request对象传过去
        // 这种方式虽然可以实现在A中请求域的对象在B中能访问，
        // 但是这种方式是不可取的，因为我们自己new的Servlet对象不受Tomcat服务器所管理
        /* BServlet bServlet = new BServlet();
        bServlet.doGet(request, response);*/

        // 资源跳转
        // 第一步：获取请求转发器对象。（参数是BServlet在app中的路径）
        // 相当于把"/b"这个路径包装到请求转发器当中，实际上是把下一个跳转的资源的路径告知给Tomcat服务器了。
        RequestDispatcher dispatcher = request.getRequestDispatcher("/b");

        // 第二步：调用请求转发器的forward方法，进行转发。
        dispatcher.forward(request, response);
    }
}
