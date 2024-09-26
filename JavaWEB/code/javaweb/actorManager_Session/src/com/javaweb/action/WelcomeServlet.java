package com.javaweb.action;

import com.javaweb.bean.User;
import com.javaweb.dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user")!=null){
            // 如果存在session则直接可以跳转到list页面
            response.sendRedirect(request.getContextPath() + "/actor/list");
            return;
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String username = null;
            String password = null;
            // 获取cookie中保存的用户名和密码
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName()))
                    username = cookie.getValue();
                else if ("password".equals(cookie.getName()))
                    password = cookie.getValue();
            }
            if (username != null && password != null){
                // 如果cookie中用户名和密码都都在，则判断数据库中是否存在该用户
                UserDao dao = new UserDao();
                boolean exist = dao.isExist(new User(username, password));
                if(exist){
                    // 存在，需要先将用户存储到session中，然后直接跳转到list页面
                    session.setAttribute("user", new User(username,password));
                    response.sendRedirect(request.getContextPath() + "/actor/list");
                    return;
                }
            }
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
