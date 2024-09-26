package com.javaweb.action;

import com.javaweb.dao.ActorDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/actor/modify")
public class ActorModifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int actorId = Integer.parseInt(request.getParameter("actorId"));
        String actorName = request.getParameter("actorName");
        String actorWork = request.getParameter("actorWork");
        ActorDao dao = new ActorDao();
        boolean updated = dao.updateById(actorId, actorName, actorWork);
        if (updated) {
            // 更新成功
            response.sendRedirect(request.getContextPath() + "/actor/list");
        }else{
            // 更新失败
            response.sendRedirect(request.getContextPath() + "/error.html");
        }
    }
}
