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

@WebServlet("/dept/list")
public class DeptListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 获取应用的根路径
        String rootPath = request.getContextPath();

        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("    <title>部门列表页面</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("    <script type='text/javascript'>");
        out.print("        function del(dno){");
        // out.print("            alert('执行删除操作')");
        out.print("            if(window.confirm('亲，删除了之后不可恢复哦!!!')) {");
        out.print("                document.location.href='" + rootPath + "/dept/delete?deptno=' + dno");
        out.print("            }");
        out.print("        }");
        out.print("    </script>");
        out.print("    <h1 align='center'>部门列表</h1>");
        out.print("    <hr>");
        out.print("    <table border='1px' align='center' width='50%' >");
        out.print("        <tr>");
        out.print("            <th>序号</th>");
        out.print("            <th>部门编号</th>");
        out.print("            <th>部门名称</th>");
        out.print("            <th>操作</th>");
        out.print("        </tr>");

        // 连接数据库，查询所有的部门
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int i = 1;
        try {
            connection = DBUtil.getConnection();
            String sql = "select deptno, dname from dept";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                String deptno = resultSet.getString("deptno");
                String dname = resultSet.getString("dname");
                out.print("        <tr align='center'>");
                out.print("            <td>" + (i++) + "</td>");
                out.print("            <td>" + deptno + "</td>");
                out.print("            <td>" + dname + "</td>");
                out.print("            <td>");
                out.print("                <a href='javascript:void(0)' onclick='del(" + deptno + ")'>删除</a>");
                out.print("                <a href='" + rootPath + "/dept/edit?deptno=" + deptno + "'>修改</a>");
                out.print("                <a href='" + rootPath + "/dept/detail?deptno=" + deptno + "'>详情</a>");
                out.print("            </td>");
                out.print("        </tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }

        out.print("    </table>");
        out.print("    <hr>");
        out.print("    <h4><a href='/oa/add.html'>点击新增部门</a></h4>");
        out.print("</body>");
        out.print("</html>");
    }
}
