package com.javaweb.action;

import com.javaweb.bean.Actor;
import com.javaweb.dao.ActorDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/actor/edit")
public class ActorEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int actorId = Integer.parseInt(request.getParameter("actorId"));
        ActorDao dao = new ActorDao();
        Actor actor = dao.selectById(actorId);
        if (actor == null) {
            response.sendRedirect(request.getContextPath() + "/error.html");
        } else {
            out.print("<!DOCTYPE html>");
            out.print("<html lang='en'>");
            out.print("<head>");
            out.print("    <meta charset='UTF-8'>");
            out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.print("    <title>修改演员信息页面</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("    <h1>修改演员信息页面</h1>");
            out.print("    <form action='" + request.getContextPath() + "/actor/modify' method='post'>");
            out.print("                演员编号<input type='text' name='actorId' value='" + actor.getActorId() + "' readonly><br>");
            out.print("                演员姓名<input type='text' name='actorName' value='" + actor.getActorName() + "'> <br>");
            out.print("                演员作品<input type='text' name='actorWork' value='" + actor.getActorWork() + "'> <br>");
            out.print("        <input type='submit' value='修改'><br>");
            out.print("    </form>");
            out.print("</body>");
            out.print("</html>");
        }
    }
}
