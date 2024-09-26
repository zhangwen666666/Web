package com.javaweb.filter;

import jakarta.servlet.*;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletResponseWrapper;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/actor/list", "/actor/detail", "/actor/add", "/actor/delete", "/actor/modify",
        "/add.jsp", "/detail.jsp","/edit.jsp", "/list.jsp"})
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("user")!=null){
            chain.doFilter(request,response);
        }else {
            response.sendRedirect(request.getContextPath() + "/welcome");
        }
    }
}
