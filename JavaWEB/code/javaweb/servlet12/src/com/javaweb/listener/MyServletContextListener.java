package com.javaweb.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 这个方法是在ServletContext对象被创建的时候调用。(服务器启动时)
        System.out.println("ServletContext对象创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 这个方法是在ServletContext对象被销毁的时候调用。(服务器关闭时)
        System.out.println("ServletContext对象销毁了");
    }
}
