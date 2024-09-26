package com.javaweb.action;

import com.javaweb.dao.ActorDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/actor/delete")
public class ActorDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int actorId = Integer.parseInt(request.getParameter("actorId"));
        ActorDao dao = new ActorDao();
        boolean deleted = dao.deleteById(actorId);
        if(deleted){
            // out.print("删除成功");
            response.sendRedirect(request.getContextPath() + "/actor/list");
        }else {
            response.sendRedirect(request.getContextPath() + "/error.html");
        }
    }
}
