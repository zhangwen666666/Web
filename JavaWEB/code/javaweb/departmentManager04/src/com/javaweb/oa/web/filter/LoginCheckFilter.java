package com.javaweb.oa.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletResponseWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 获取请求路径
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession(false);
        if ((session != null && session.getAttribute("user") != null)
                || "/welcome".equals(servletPath) || "/index.jsp".equals(servletPath)
                || "/user/login".equals(servletPath) || "/user/exit".equals(servletPath)) {
            chain.doFilter(request,response);
        } else {
            response.sendRedirect(request.getContextPath() + "/welcome");
        }
    }
}
