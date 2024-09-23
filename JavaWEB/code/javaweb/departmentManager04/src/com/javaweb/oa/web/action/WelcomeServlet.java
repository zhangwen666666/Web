package com.javaweb.oa.web.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/welcome"})
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            // cookie不为空，则获取用户名和密码
            String username = null;
            String password = null;
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("username".equals(name)) {
                    username = cookie.getValue();
                } else if ("password".equals(name)) {
                    password = cookie.getValue();
                }
            }

            if (username != null && password != null) {
                // 用户名和密码都不为空，则连接数据库，判断用户名和密码是否正确
                /*Connection connection = null;
                PreparedStatement ps = null;
                ResultSet rs = null;
                try {
                    connection = DBUtil.getConnection();
                    String sql = "select * from t_user"
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    DBUtil.close(connection, ps, rs);
                }*/
                response.sendRedirect(request.getContextPath() + "/user/login?username=" + username + "&password=" + password);
            } else {
                // 用户名和密码至少有一个是null，则返回登录页面
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        } else {
            // cookie为空跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
