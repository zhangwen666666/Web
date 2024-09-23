package com.javaweb.oa.web.action;

import com.javaweb.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet({"/user/login", "/user/exit"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/user/login".equals(servletPath)) {
            doLogin(request, response);
        } else if ("/user/exit".equals(servletPath)) {
            doExit(request, response);
        }
    }


    protected void doExit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取session对象
        HttpSession session = request.getSession(false);
        // 销毁session
        if (session != null) {
            session.invalidate();
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    if ("username".equals(name) || "password".equals(name)){
                        cookie.setMaxAge(0);
                        cookie.setPath(request.getContextPath());
                        response.addCookie(cookie);
                    }
                }
            }
            // 跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    protected void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 验证用户名和密码是否正确
        // 获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 连接数据库验证用户名和密码
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean success = false;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from t_user where username=? and password=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            success = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }

        if (success) {
            // 获取session对象
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // 登录成功
            // 如果用户选择了"十天内免登录"，则创建cookie
            String flag = request.getParameter("flag");
            //System.out.println(flag);
            if("true".equals(flag)){
                // 选择了十天内免登录
                Cookie cookie1 = new Cookie("username", username);  // 保存用户名
                Cookie cookie2 = new Cookie("password", password);  // 保存密码(真实情况下是加密的)
                // 设置cookie有效期
                cookie1.setMaxAge(60*60*24*10);
                cookie2.setMaxAge(60*60*24*10);
                // 设置cookie路径
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());
                // 响应cookie给浏览器
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            // 登录失败
            response.sendRedirect(request.getContextPath() + "/loginError.jsp");
        }
    }
}
