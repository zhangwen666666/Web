package com.javaweb.action;

import com.javaweb.bean.User;
import com.javaweb.dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/user/login", "/user/exit"})
public class UserServlet extends jakarta.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/user/login".equals(servletPath)) {
            // 处理登录业务
            doLogin(request, response);
        } else if ("/user/exit".equals(servletPath)) {
            // 处理退出系统业务
            doExit(request, response);
        }
    }

    private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 清除session
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            session.removeAttribute("user");
            session.invalidate();
        }
        // 清除cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if("username".equals(cookie.getName()) || "password".equals(cookie.getName())){
                    cookie.setMaxAge(0);
                    cookie.setPath(request.getContextPath());
                    response.addCookie(cookie);
                }
            }
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String loginFree = request.getParameter("loginFree");
        // System.out.println(loginFree);
        UserDao dao = new UserDao();
        User user = new User(username, password);
        boolean exist = dao.isExist(user);
        if (exist) {
            // 登录成功
            // 保存session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            // 如果选择了三天内免登录
            if ("true".equals(loginFree)) {
                // 保存cookie
                Cookie cookie1 = new Cookie("username", username);
                Cookie cookie2 = new Cookie("password", password);
                cookie1.setMaxAge(60 * 60 * 24 * 3);
                cookie2.setMaxAge(60 * 60 * 24 * 3);
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            // 跳转到list页面
            response.sendRedirect(request.getContextPath() + "/actor/list");
        } else {
            // 登录失败，跳转到登录失败页面 让用户重新登录
            response.sendRedirect(request.getContextPath() + "/loginError.jsp");
        }
    }
}
