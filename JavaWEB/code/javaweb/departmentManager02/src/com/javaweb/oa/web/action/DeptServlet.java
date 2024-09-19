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

@WebServlet({"/dept/list", "/dept/detail", "/dept/modify", "/dept/delete", "/dept/edit", "/dept/save"})
// 模糊匹配，只要请求路径是以"/dept"开始的，都走这个servlet
//@WebServlet("/dept/*")
public class DeptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/dept/list".equals(servletPath)) {
            doList(request, response);
        } else if ("dept/save".equals(servletPath)) {
            doSave(request, response);
        } else if ("/dept/detail".equals(servletPath)) {
            doDetail(request, response);
        } else if ("/dept/modify".equals(servletPath)) {
            doModify(request, response);
        } else if ("/dept/delete".equals(servletPath)) {
            doDel(request, response);
        } else if ("/dept/edit".equals(servletPath)) {
            doEdit(request, response);
        }
    }

    private void doSave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
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

    private void doList(HttpServletRequest request, HttpServletResponse response)
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

    private void doDetail(HttpServletRequest request, HttpServletResponse response)
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

    private void doModify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

    private void doDel(HttpServletRequest request, HttpServletResponse response)
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
                // request.getRequestDispatcher("/dept/list").forward(request, response);
                // 重定向
                response.sendRedirect(request.getContextPath() + "/dept/list");
            } else {
                // out.print("<script>alert('删除失败'); window.location.href='/oa/error.html';</script>");
                request.getRequestDispatcher("/error.html").forward(request,response);
                response.sendRedirect(request.getContextPath() + "/error.html");
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

    private void doEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
