package com.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajaxrequest6")
public class AjaxRequest6Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 注意响应的内容类型是xml
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /*
        <students>
            <student>
                <name>张三</name>
                <age>20</age>
                <addr>天津市和平区</addr>
            </student>
            <student>
                <name>李四</name>
                <age>10</age>
                <addr>天津市南开区</addr>
            </student>
        </students>
         */
        StringBuilder xml = new StringBuilder();
        xml.append("<students>");
        xml.append("<student>");
        xml.append("<name>张三</name>");
        xml.append("<age>20</age>");
        xml.append("<addr>天津市和平区</addr>");
        xml.append("</student>");
        xml.append("<student>");
        xml.append("<name>李四</name>");
        xml.append("<age>10</age>");
        xml.append("<addr>天津市南开区</addr>");
        xml.append("</student>");
        xml.append("</students>");
        out.print(xml);
    }
}
