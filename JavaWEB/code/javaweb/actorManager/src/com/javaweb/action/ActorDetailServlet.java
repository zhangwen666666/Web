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

@WebServlet("/actor/detail")
public class ActorDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int actorId = Integer.parseInt(request.getParameter("actorId"));
        ActorDao dao = new ActorDao();
        Actor actor = dao.selectById(actorId);
        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("    <title>演员详情页面</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("    <h1>演员详情</h1>");
        out.print("    <hr>");
        out.print("    演员编号: " + actor.getActorId() + " <br>");
        out.print("    演员姓名: " + actor.getActorName() + " <br>");
        out.print("    演员作品: " + actor.getActorWork() + " <br>");
        out.print("    <input type='button' value='返回' onclick='window.history.back()'>");
        out.print("</body>");
        out.print("</html>");
    }
}
