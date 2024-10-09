package com.ajax.servlet;

import com.ajax.beans.Student;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ajaxrequest5")
public class AjaxRequest5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 连接数据库，查询信息。。。。
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 拼串
        /*StringBuilder html = new StringBuilder();
        html.append("<tr>");
        html.append("    <td>1</td>");
        html.append("    <td>张三</td>");
        html.append("    <td>18</td>");
        html.append("    <td>北京大兴区</td>");
        html.append("</tr>");
        html.append("<tr>");
        html.append("    <td>2</td>");
        html.append("    <td>李四</td>");
        html.append("    <td>28</td>");
        html.append("    <td>北京海淀区</td>");
        html.append("</tr>");

        out.print(html);*/

        // 将以上程序拼接HTML，换成拼接JSON格式的字符串
        /*StringBuilder jsonStr = new StringBuilder();
        jsonStr.append("[");
        jsonStr.append("{\"name\": \"王五\", \"age\": 20, \"addr\": \"北京大兴区\"}");
        jsonStr.append(",");
        jsonStr.append("{\"name\": \"李四\", \"age\": 18, \"addr\": \"北京丰台区\"}");
        jsonStr.append("]");
        // 响应给浏览器
        out.print(jsonStr);*/

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 准备StringBuilder拼接json
        /*StringBuilder jsonStr = new StringBuilder();*/
        /*jsonStr.append("[");*/
        List<Student> studentList = new ArrayList<>();
        String jsonStr = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "1234");
            String sql = "select name,age,addr from t_stu";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                // 获取每个学生的信息
                String name = rs.getString("name");
                String age = rs.getString("age");
                String addr = rs.getString("addr");
                // {"name": "    李四   ", "age":    18    , "addr": "   北京丰台区  "},
                /*jsonStr.append("{\"name\": \"");
                jsonStr.append(name);
                jsonStr.append("\", \"age\": ");
                jsonStr.append(age);
                jsonStr.append(", \"addr\": \"");
                jsonStr.append(addr);
                jsonStr.append("\"},");*/

                Student s = new Student(name, Integer.parseInt(age), addr);
                studentList.add(s);
            }
            // 将List集合转换成json字符串
            jsonStr = JSON.toJSONString(studentList);
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
        // 裁掉多余的","号
        /*if (jsonStr.charAt(jsonStr.length() - 1) == ',') {
            jsonStr.deleteCharAt(jsonStr.length() - 1);
        }
        jsonStr.append("]");*/

        out.print(jsonStr);
    }
}
