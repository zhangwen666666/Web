package org.apache;

import java.util.Scanner;
import java.io.FileReader;
import java.util.Properties;
import javax.servlet.Servlet;

// 充当Tomcat服务器的开发者
public class Tomcat{
	public static void main(String[] args) throws Exception{
		System.out.println("Tomcat服务器启动成功，开始接受用户的访问");
		// String currentPath = System.getProperty("user.dir");
		// System.out.println(currentPath);
		
		// 简单的使用Scanner来模拟一下用户的请求
		// 用户访问服务器是通过浏览器上的“请求路径”
		// 也就是说用户请求路径不同，后台执行的Servlet不同
		/*
			/userList		userListServlet
			/login			userLoginServlet
			/bank			BankServlet
		*/
		
		System.out.print("请输入您的访问路径: ");
		Scanner scanner = new Scanner(System.in);
		
		// 用户请求的路径
		String key = scanner.nextLine();
		
		// Tomcat服务器应该通过用户的请求路径找对应的XXXServlet
		// 请求路径和XXXServlet之间的关系应该由谁来指定呢？
		// 对于Tomcat服务器来说需要解析配置文件
		// ResourceBundle bundle = ResourceBundle.getBundle("web");
		FileReader reader = new FileReader("web.properties");
		Properties pro = new Properties();
		pro.load(reader);
		reader.close();
		
		// 通过key获取value
		String className = pro.getProperty(key);
		// 通过反射机制创建对象
		Class c = Class.forName(className);
		Object obj = c.newInstance(); // obj的类型对于Tomcat服务器开发人员来说不知道
		// 但是Tomcat服务器的开发者知道，你写的XXXServlet一定实现了Servlet接口
		Servlet servlet = (Servlet) obj;
		servlet.service();
	}
}