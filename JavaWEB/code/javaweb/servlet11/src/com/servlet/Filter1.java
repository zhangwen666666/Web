package com.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class Filter1 implements Filter {
    public Filter1() {
        System.out.println("无参数构造方法执行");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init方法执行");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 在请求的时候添加过滤规则
        System.out.println("doFilter方法开始执行");
        // 执行下一个过滤器，如果下一个不是过滤器了，则执行目标程序Servlet
        chain.doFilter(request, response);
        // 在响应的时候添加过滤规则
        System.out.println("doFilter方法执行结束");
    }

    @Override
    public void destroy() {
        System.out.println("destroy方法执行");
    }
}
