package com.ajax.servlet;

import com.ajax.beans.Area;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/listArea")
public class ListAreaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 连接数据库，获取所有的对应区域
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Area> areaList = new ArrayList<>();
        String jsonString = null;
        request.setCharacterEncoding("UTF-8");
        String pcode = request.getParameter("pcode");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "1234");
            String sql = "";
            if (pcode == null) {
                sql = "select code, name from t_area where pcode is null";
                ps = connection.prepareStatement(sql);
            } else {
                sql = "select code, name from t_area where pcode = ?";
                ps = connection.prepareStatement(sql);
                ps.setString(1, pcode);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                Area area = new Area(code, name);
                areaList.add(area);
            }
            // 使用fastjson将json对象转换成json字符串
            jsonString = JSON.toJSONString(areaList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
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

        response.setContentType("test/html;charset=UTF-8");
        response.getWriter().print(jsonString);
    }
}
