package com.javaweb.oa.web.action;

import com.javaweb.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 获取部门编号
        String deptno = request.getParameter("deptno");
        // out.print("删除" + deptno);

        // 连接数据库完成删除操作
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            // 开启事务
            connection.setAutoCommit(false);
            String sql = "delete from dept where deptno=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(deptno));
            int count = preparedStatement.executeUpdate();
            connection.commit();
            if (count == 1) {
                // out.print("<script>alert('删除成功'); window.location.href='/oa/dept/list';</script>");
                 request.getRequestDispatcher("/dept/list").forward(request, response);
            } else {
                // out.print("<script>alert('删除失败'); window.location.href='/oa/error.html';</script>");
                 request.getRequestDispatcher("/error.html").forward(request,response);
            }
            // 提交事务
        } catch (SQLException e) {
            // 回滚事务
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
