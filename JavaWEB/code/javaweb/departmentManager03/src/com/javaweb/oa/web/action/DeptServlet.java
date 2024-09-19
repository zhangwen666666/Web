package com.javaweb.oa.web.action;

import com.javaweb.oa.bean.Dept;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/dept/list", "/dept/detail", "/dept/delete", "/dept/save",
       // "/dept/edit"
        "/dept/modify",
})
public class DeptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        switch (servletPath) {
            case "/dept/list" -> {
                doList(request, response);
            }
            case "/dept/detail" -> {
                doDetail(request, response);
            }
            case "/dept/delete" -> {
                doDel(request, response);
            }
            case "/dept/save" -> {
                doSave(request, response);
            }
//            case "/dept/edit" -> {
//                doEdit(request, response);
//            }
            case "/dept/modify" -> {
                doModify(request, response);
            }
        }
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
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            String sql = "update dept set dname=?, loc=? where deptno=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, dname);
            statement.setString(2, loc);
            statement.setInt(3, Integer.parseInt(deptno));
            count = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
        if (count == 1) {
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }


    /*private void doEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Dept dept = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select dname, loc from dept where deptno=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(deptno));
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String dname = resultSet.getString("dname");
                String loc = resultSet.getString("loc");
                dept = new Dept(Integer.parseInt(deptno), dname, loc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, resultSet);
        }
        if (dept != null) {
            request.setAttribute("dept", dept);
            request.getRequestDispatcher("/edit.jsp").forward(request,response);
        }else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }*/


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
                // 最好使用重定向
                response.sendRedirect(request.getContextPath() + "/dept/list");
            } else {
                // 重定向
                response.sendRedirect(request.getContextPath() + "/error.jsp");
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


    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取部门编号
        String deptno = request.getParameter("deptno");
        Connection connection = null;
        PreparedStatement statement = null;
        int count = 0;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from dept where deptno=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(deptno));
            count = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }

        if (count == 1) {
            // 删除成功
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            // 删除失败
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }


    /**
     * 根据部门编号获取部门信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取部门编号
        String deptno = request.getParameter("deptno");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Dept dept = null;
        try {
            connection = DBUtil.getConnection();
            connection.setAutoCommit(false);
            String sql = "select dname, loc from dept where deptno=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(deptno));
            resultSet = statement.executeQuery();
            connection.commit();
            if (resultSet.next()) {
                String dname = resultSet.getString("dname");
                String loc = resultSet.getString("loc");
                dept = new Dept(Integer.parseInt(deptno), dname, loc);
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }

        if (dept != null) {
            request.setAttribute("dept", dept);
            // request.getRequestDispatcher("/detail.jsp").forward(request, response);
            // 实现修改和详情公用同一个页面
            String f = request.getParameter("f");
            if("m".equals(f)){
                // 转发到修改页面
                request.getRequestDispatcher("/edit.jsp").forward(request, response);
            }else if("d".equals(f)) {
                // 转发到详情页面
                request.getRequestDispatcher("/detail.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }


    /**
     * 连接数据库，查询所有的部门信息，将部门信息手机号，然后跳转到JSP做页面展示
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 准备一个容器，用来专门存储部门
        List<Dept> deptList = new ArrayList<>();
        // 连接数据库，查询所有的部门信息
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            connection.setAutoCommit(false);
            String sql = "select deptno, dname from dept";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            connection.commit();
            while (resultSet.next()) {
                String deptno = resultSet.getString("deptno");
                String dname = resultSet.getString("dname");
                // System.out.println(deptno + "=" + dname);

                //将以上零散的数据封装成java对象
                Dept dept = new Dept(Integer.parseInt(deptno), dname);

                // 将部门对象方法list集合当中
                deptList.add(dept);
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }

        // 将集合放入请求域
        request.setAttribute("deptList", deptList);
        // 转发，不要重定向
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
