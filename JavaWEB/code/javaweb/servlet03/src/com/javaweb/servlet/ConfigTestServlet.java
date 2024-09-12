package com.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * ServletConfig
 *   1. ServletConfig是什么?
 *      jakarta.servlet.ServletConfig
 *      显然ServletConfig是Servlet规范中的一员。
 *      ServletConfig是一个接口。
 *   2. 谁去实现了这个接口呢? WEB服务器
 *      public class org.apache.catalina.core.StandardWrapperFacade implements ServletConfig {}
 *      结论：Tomcat服务器实现了ServletConfig接口
 *      如果将Tomcat服务器换为jetty服务器，输出ServletConfig对象的时候，就不一定是这个结果了
 *      包名类名可能和Tomcat不一样，但是他们都是实现了ServletConfig这个规范
 *   3. 一个Servlet对象中有一个ServletConfig对象。(Servlet对象和ServletConfig对象是一对一)
 *   4. ServletConfig对象是Tomcat服务器(WEB服务器)创建的。在创建Servlet对象的时候，同时创建了ServletConfig对象
 *   5. ServletConfig接口到底是干啥的？有什么用？
 *      ServletConfig对象是Servlet对象的配置信息对象。
 *   6. ServletConfig对象中到底包装了什么信息呢？
 *          <servlet>
 *              <servlet-name>configservlet</servlet-name>
 *              <servlet-class>com.javaweb.servlet.ConfigTestServlet</servlet-class>
 *          </servlet>
 *      ServletConfig对象中包装的信息就是：web.xml文件中<servlet></servlet>标签的配置信息。
 *      Tomcat解析web.xml文件，将web.xml文件中<servlet></servlet>标签的配置信息自动包装到ServletConfig对象中。
 *   7.ServletConfig对象有什么方法？
 *         <servlet>
 *             <servlet-name>configservlet</servlet-name>
 *             <servlet-class>com.javaweb.servlet.ConfigTestServlet</servlet-class>
 *             <!-- 这里可以配置一个Servlet对象的初始化信息 -->
 *             <init-param>
 *                 <param-name>driver</param-name>
 *                 <param-value>com.mysql.cj.jdbc.driver</param-value>
 *             </init-param>
 *             <init-param>
 *                 <param-name>url</param-name>
 *                 <param-value>jdbc:mysql:://localhost:3306/exam</param-value>
 *             </init-param>
 *             <init-param>
 *                 <param-name>user</param-name>
 *                 <param-value>root</param-value>
 *             </init-param>
 *             <init-param>
 *                 <param-name>password</param-name>
 *                 <param-value>1234</param-value>
 *             </init-param>
 *         </servlet>
 *     以上<servlet></servlet>标签中的<init-param></init-param>是初始化参数。这个初始化参数信息会自动被小猫咪
 *     封装到ServletConfig对象当中
 */
public class ConfigTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        // 获取ServletConfig对象
        jakarta.servlet.ServletConfig config = this.getServletConfig();
        // 输出该对象
        writer.print("ServletConfig对象是：" + config);//org.apache.catalina.core.StandardWrapperFacade@5493877a
        // 获取<servlet-name>
        String servletName = config.getServletName();
        writer.print("<br><hr><servlet-name>" + servletName + "</servlet-name>");//configservlet
        // 通过ServletConfig对象中的两个方法可以获取到web.xml文件中的初始化参数配置信息。
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        // 遍历集合
        while(initParameterNames.hasMoreElements()){
            String parameterName = initParameterNames.nextElement();
            // 通过参数名获取参数值
            String parameterValue = config.getInitParameter(parameterName);
            writer.print("<br>" + parameterName + "=" + parameterValue);
        }

        // 通过this也可以调用config对象中的方法
        Enumeration<String> parameterNames = this.getInitParameterNames();
        while(parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            String parameterValue = this.getInitParameter(parameterName);
            writer.print("<br>" + parameterName + "=" + parameterValue);
        }

        // 怎么获取ServletContext对象？
        // 通过ServletConfig对象获取ServletContext对象。
        // 通过this也可以获取到ServletContext对象。
        ServletContext application = config.getServletContext();
        // 输出
        writer.print("<br>" + application);
        writer.print("<br>" + this.getServletContext());
    }
}
