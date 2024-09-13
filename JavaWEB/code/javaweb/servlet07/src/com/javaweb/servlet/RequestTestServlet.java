package com.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

public class RequestTestServlet extends HttpServlet {

/*    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 面向接口编程： HttpServletRequest接口。
        // 获取参数Map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 遍历Map集合
        parameterMap.forEach((key,value) -> {
            System.out.println(key + "=" + Arrays.toString(value));
        });
//        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
//        for (Map.Entry<String, String[]> entry : entries) {
//            System.out.println(entry.getKey() + "=" + Arrays.toString(entry.getValue()));
//        }

        // 获取所有的name
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            String[] parameterValues = request.getParameterValues(name);
            System.out.println(name + "=" + Arrays.toString(parameterValues));
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(request + "<br>");

        // 获取客户端的IP地址
        String remoteAddr = request.getRemoteAddr();
        out.print(remoteAddr + "<br>");
    }
}
