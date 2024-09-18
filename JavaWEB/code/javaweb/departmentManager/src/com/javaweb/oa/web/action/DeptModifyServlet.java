package com.javaweb.oa.web.action;

import com.javaweb.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptModifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决请求体中的中文乱码问题
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 获取请求体当中的数据
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        // 连接数据库完成更新
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "update dept set dname=?, loc=? where deptno=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, dname);
            statement.setString(2, loc);
            statement.setInt(3, Integer.parseInt(deptno));
            int count = statement.executeUpdate();
            if (count == 1) {
                // out.print("<script>alert('更新成功'); window.location.href='/oa/dept/list';</script>");
                response.sendRedirect(request.getContextPath() + "/dept/list");
            } else {
                // out.print("<script>alert('更新失败'); window.location.href='/oa/dept/list';</script>");
                response.sendRedirect(request.getContextPath() + "/dept/list");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }
}
