package com.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StudentServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // 设置响应的内容类型
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // 连接数据库
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://localhost:3306/exam";
            String user = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, user, password);
            // 获取预编译的数据库操作对象
            String sql = "select `s#` as sno, sname from student";
            statement = connection.prepareStatement(sql);
            // 执行sql语句
            resultSet = statement.executeQuery();
            // 处理结果集
            while(resultSet.next()){
                String no = resultSet.getString("sno");
                String name = resultSet.getString("sname");
                // System.out.println(no + "," + name);
                out.print(no + "," + name + "<br>");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
