package com.servlet;

import javax.servlet.Servlet;

public class UserLoginServlet implements Servlet{
	public void service(){
		System.out.println("UserLoginServlet's service...");
	}
}