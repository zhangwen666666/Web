package com.servlet;

import jakarta.servlet.*;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("doFilter2方法开始执行");
        // 执行下一个过滤器，如果下一个不是过滤器了，则执行目标程序Servlet
        chain.doFilter(request, response);
        // 在响应的时候添加过滤规则
        System.out.println("doFilter2方法执行结束");
    }
}
