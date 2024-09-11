package com.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet implements Servlet{
	// 有5个方法
	public void init(ServletConfig config) throws ServletException{
		
	}
	
	public void service(ServletRequest request, ServletResponse response)
		throws ServletException, IOException{
		// 向控制台打印输出
		System.out.println("My First Servlet, Hello Servlet");
		
		// 设置响应的内容类型是文本或html代码
		response.setContentType("text/html");
		// 怎么将一个信息直接输出到浏览器上？
		// 需要使用ServletResponse接口：response
		// response表示响应：从服务器向浏览器发送数据叫响应
		PrintWriter out = response.getWriter();
		
		// 这行代码不要放在这里，要在获取流之前设置
		// response.setContentType("text/html");
		
		out.print("Hello Servlet, You are my first servlet");
		
		// 浏览器是能够识别html代码的，我们可以输出一段HTML代码
		out.print("<h1>Hello Servlet，你好Servlet</h1>");
		
		// out是一个输出流，负责输出字符串到浏览器
		// 这个流不需要我们刷新和关闭，这些都有Tomcat来维护
	}
	
	public void destroy(){
		
	}
	
	public String getServletInfo(){
		return "";
	}
	
	public ServletConfig getServletConfig(){
		return null;
	}
	
}