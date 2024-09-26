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
import java.util.List;

@WebServlet({"/actor/list"})
public class ActorListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // out.print("演员列表");
        ActorDao dao = new ActorDao();
        List<Actor> actorList = dao.selectAll();
        out.print("<script>");
        out.print("    function del(actorId){");
        out.print("        if(window.confirm('亲, 删了不可恢复哦!!!')){");
        out.print("           window.location.href='" + request.getContextPath() + "/actor/delete?actorId='+actorId");
        out.print("        }");
        out.print("    }");
        out.print("</script>");
        out.print("<h1 align='center'>演员列表</h1>");
        out.print("<hr>");
        out.print("<table border='1px' width='50%' align='center'>");
        out.print("    <tr align='center'>");
        out.print("        <th>序号</th>");
        out.print("        <th>演员编号</th>");
        out.print("        <th>姓名</th>");
        out.print("        <th>操作</th>");
        out.print("    </tr>");
        for (int i = 1; i <= actorList.size(); i++) {
            Actor actor = actorList.get(i - 1);
            out.print("    <tr align='center'>");
            out.print("        <td>" + i + "</td>");
            out.print("        <td>" + actor.getActorId() + "</td>");
            out.print("        <td>" + actor.getActorName() + "</td>");
            out.print("        <td>");
            out.print("            <a href='javascript:void(0)' onclick='del(" + actor.getActorId() + ")'>删除</a>");
            out.print("            <a href='" + request.getContextPath() + "/actor/edit?actorId=" + actor.getActorId() + "'>修改</a>");
            out.print("            <a href='" + request.getContextPath() + "/actor/detail?actorId=" + actor.getActorId() + "'>详情</a>");
            out.print("        </td>");
            out.print("    </tr>");
        }
        out.print("</table>");
        out.print("<hr>");
        out.print("<h3>");
        out.print("    <a href='" + request.getContextPath() + "/add.html'>点击新增演员</a>");
        out.print("</h3>");
    }
}
