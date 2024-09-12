package com.java.servlet;

import jakarta.servlet.*;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


/**
 * ServletContext
 *  1. ServletContext是什么?
 *      ServletContext是接口，是Servlet规范中的一员。
 *  2. ServletContext是谁实现的？
 *      Tomcat服务器(WEB服务器) 实现了ServletContext接口。
 *      public class org.apache.catalina.core.ApplicationContextFacade implements ServletContext {}
 *  3. ServletContext对象是谁创建的？在什么时候创建的？
 *      ServletContext对象是WEB服务器启动的时候创建。是WEB服务器创建的，在服务器关闭的时候被销毁
 *      对于一个webapp来说，ServletContext对象只有一个
 *  4. ServletContext怎么理解？
 *      Servlet对象的环境(上下文)对象。
 *      ServletContext对象其实对应的就是整个web.xml文件。
 *      放在ServletContext对象中的数据，所有Servlet对象都是可以共享的
 *      Tomcat是一个容器，一个容器当中可以放多个webapp，一个webapp对应一个ServletContext对象
 */
public class AServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // 获取ServletContext对象
        jakarta.servlet.ServletContext application = this.getServletContext();
        out.print("servletContext对象：" + application);

        // 获取上下文的初始化参数
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String parameterName = initParameterNames.nextElement();
            String parameterValue = application.getInitParameter(parameterName);
            out.print("<br>" + parameterName + "=" + parameterValue);
        }

        // 获取应用上下文的根 context path
        String contextPath = application.getContextPath();
        out.print("<br>" + contextPath);

        // 获取文件的绝对路径
        // 后面的这个路径加了，加了一个"/"，这个"/"表示web的根，不加默认也是从根下开始找
        // String realPath = application.getRealPath("/index.html");
        // String realPath = application.getRealPath("index.html"); // 不加 / 也可以
        String realPath = application.getRealPath("/common/common.html");
        out.print("<br>" + realPath);

        // log
        // 这个日志会记录到哪里呢？
        // CATALINA_HOME/logs目录下

        application.log("大家好，欢迎学习Servlet规范");

        // 准备数据
        User user = new User("jack","1234");
        // 向ServletContext应用域当中存数据
        application.setAttribute("userObj", user);
        Object userObj = application.getAttribute("userObj");
        out.print("<br>" + userObj);
    }
}
