package com.javaweb.action;

import com.javaweb.bean.Actor;
import com.javaweb.dao.ActorDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/actor/add")
public class ActorAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int actorId = Integer.parseInt(request.getParameter("actorId"));
        String actorName = request.getParameter("actorName");
        String actorWork = request.getParameter("actorWork");
        ActorDao dao = new ActorDao();
        boolean inserted = dao.insert(new Actor(actorId, actorName, actorWork));
        if (inserted) {
            // 插入成功，返回主界面
            response.sendRedirect(request.getContextPath() + "/actor/list");
        } else {
            // 插入失败，返回错误页面
            response.sendRedirect(request.getContextPath() + "/error.html");
        }
    }
}
