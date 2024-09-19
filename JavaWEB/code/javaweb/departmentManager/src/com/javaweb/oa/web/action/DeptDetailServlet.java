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

@WebServlet("/dept/detail")
public class DeptDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("    <title>部门详情</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("    <h1>部门详情</h1>");
        out.print("    <hr>");

        // 获取要查询的部门编号
        // 虽然提交的是30，但是服务器获取的是"30"这个字符串
        String deptno = request.getParameter("deptno");
        // 连接数据库，查询指定的部门
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select dname, loc from dept where deptno=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(deptno));
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                String dname = resultSet.getString("dname");
                String loc = resultSet.getString("loc");
                out.print("                部门编号: " + deptno + " <br>");
                out.print("                部门名称: " + dname + " <br>");
                out.print("        部门位置: " + loc + " <br>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }

        out.print("    <input type='button' value='后退' onclick='window.history.back()'/>");
        out.print("</body>");
        out.print("</html>");
    }
}
