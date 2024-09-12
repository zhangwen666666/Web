package com.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;


/**
 * 编写一个标准通用的Servlet，起名GenericServlet
 * 以后所有的Servlet类都不要直接继承Servlet接口了
 * 以后所有的Servlet类都要继承GenericServlet类。
 * GenericServlet 就是一个适配器
 */
public abstract class GenericServlet implements Servlet {
    private ServletConfig config;

    /**
     * init方法中的ServletConfig对象是小猫咪创建好的。
     * 这个ServletConfig对象目前在init方法的参数上，属于局部变量
     * 那么ServletConfig对象肯定以后要在service方法中使用，怎么才能保证ServletConfig对象在service方法中能够使用呢？
     * 给一个成员变量config, 并在init方法中为该成员变量赋值
     * getServletConfig方法就可以返回这个config成员变量了
     */
    @Override
    public final void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("小猫咪创建的: " + servletConfig);
        this.config = servletConfig;
        this.init();
    }

    // 给子类提供的可以重写的init方法
    public void init(){

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    /**
     * 抽象方法：这个方法最常用，所以要求子类必须实现service方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
