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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/dept/edit")
public class DeptEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获取应用的根路径
        String contextPath = request.getContextPath();
        // 获取部门编号
        String deptno = request.getParameter("deptno");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("    <title>修改部门</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("    <h1>修改部门</h1>");
        out.print("    <hr>");
        out.print("    <form action='" + contextPath + "/dept/modify' method='post'>");

        // 连接数据库，根据部门编号查询部门信息
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select dname, loc from dept where deptno=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(deptno));
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String dname = resultSet.getString("dname");
                String loc = resultSet.getString("loc");
                out.print("                部门编号<input type='text' name='deptno' value='" + deptno + "' readonly/><br>");
                out.print("                部门名称<input type='text' name='dname' value='" + dname + "'/><br>");
                out.print("                部门位置<input type='text' name='loc' value='" + loc + "'/><br>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }

        out.print("        <input type='submit' value='修改'/><br>");
        out.print("    </form>");
        out.print("</body>");
        out.print("</html>");
    }
}
