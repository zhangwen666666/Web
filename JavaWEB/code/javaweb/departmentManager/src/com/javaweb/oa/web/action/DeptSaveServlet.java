package com.javaweb.oa.web.action;

import com.javaweb.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/dept/save")
public class DeptSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取部门的信息（注意乱码问题）
        request.setCharacterEncoding("UTF-8");
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
//        System.out.println(deptno + dname + loc);
        // 连接数据库执行sql语句
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            connection.setAutoCommit(false);
            String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(deptno));
            preparedStatement.setString(2, dname);
            preparedStatement.setString(3, loc);
            int count = preparedStatement.executeUpdate();
            connection.commit();
            if (count == 1) {
                // 这里转发之后需要使用Post请求
                // request.getRequestDispatcher("/dept/list").forward(request, response);
                // 最好使用重定向
                response.sendRedirect(request.getContextPath() + "/dept/list");
            } else {
                // request.getRequestDispatcher("/error.html").forward(request, response);
                // 重定向
                response.sendRedirect(request.getContextPath() + "/error.html");
            }
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    e.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
    }
}
