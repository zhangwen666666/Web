package com.javaweb.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class LoginServlet extends GenericServlet{

    // 有没有一种可能，需要在这个子类中重写init方法，
    // 重写了init方法可能会导致父类中的成员变量config为null
    // 不希望子类重写该方法，则在父类中init方法添加final关键字
    /*@Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("重写自己的规则");
    }*/

    // 父类中将原始的init方法添加final修饰了，子类没有办法重写这个init方法了。
    // 如果这个时候还是希望重写init方法怎么办
    // 可以在父类中定义一个新的init方法，让子类重写这个新的init方法，并且在父类原始的init方法中调用这个init方法


    @Override
    public void init() {
        System.out.println("LoginServlet init method execute");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        System.out.println("您正在登录，请稍后。。。。。。");
        // 想在子类中使用ServletConfig对象怎么办?
        ServletConfig config = this.getServletConfig();
        System.out.println("service方法中拿到的config对象：" + config);
    }
}
