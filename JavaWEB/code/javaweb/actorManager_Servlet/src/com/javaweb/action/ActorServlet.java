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

//@WebServlet({"/actor/list", "/actor/detail", "/actor/add", "/actor/delete", "/actor/edit", "/actor/modify"})
@WebServlet({"/actor/list", "/actor/detail", "/actor/add", "/actor/delete", "/actor/modify"})
public class ActorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        switch (servletPath) {
            case "/actor/list" -> {
                doList(request, response);
            }
            case "/actor/detail" -> {
                doDetail(request, response);
            }
            case "/actor/add" -> {
                doAdd(request, response);
            }
            case "/actor/delete" -> {
                doDel(request, response);
            }
/*            case "/actor/edit" -> {
                doEdit(request, response);
            }*/
            case "/actor/modify" -> {
                doModify(request, response);
            }
        }
    }

    private void doModify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int actorId = Integer.parseInt(request.getParameter("actorId"));
        String actorName = request.getParameter("actorName");
        String actorWork = request.getParameter("actorWork");
        ActorDao dao = new ActorDao();
        boolean updated = dao.updateById(actorId, actorName, actorWork);
        if (updated) {
            // 更新成功
            response.sendRedirect(request.getContextPath() + "/actor/list");
        } else {
            // 更新失败
            response.sendRedirect(request.getContextPath() + "/error.html");
        }
    }

/*    private void doEdit(HttpServletRequest request, HttpServletResponse response)
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
    }*/

    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int actorId = Integer.parseInt(request.getParameter("actorId"));
        ActorDao dao = new ActorDao();
        boolean deleted = dao.deleteById(actorId);
        if (deleted) {
            // out.print("删除成功");
            response.sendRedirect(request.getContextPath() + "/actor/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.html");
        }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response)
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

    private void doDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int actorId = Integer.parseInt(request.getParameter("actorId"));
        String isEdit = request.getParameter("isEdit");
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
            out.print("    <title>演员详情页面</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("    <h1>演员详情</h1>");
            out.print("    <hr>");
            if ("true".equals(isEdit)) {
                out.print("    <form action='" + request.getContextPath() + "/actor/modify' method='post'>");
                out.print("                演员编号<input type='text' name='actorId' value='" + actor.getActorId() + "' readonly><br>");
                out.print("                演员姓名<input type='text' name='actorName' value='" + actor.getActorName() + "'> <br>");
                out.print("                演员作品<input type='text' name='actorWork' value='" + actor.getActorWork() + "'> <br>");
                out.print("        <input type='submit' value='修改'><br>");
                out.print("    </form>");
            } else {
                out.print("    演员编号: " + actor.getActorId() + " <br>");
                out.print("    演员姓名: " + actor.getActorName() + " <br>");
                out.print("    演员作品: " + actor.getActorWork() + " <br>");
                out.print("    <input type='button' value='返回' onclick='window.history.back()'>");
            }
            out.print("</body>");
            out.print("</html>");
        }
    }


    private void doList(HttpServletRequest request, HttpServletResponse response)
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
            out.print("            <a href='" + request.getContextPath() + "/actor/detail?isEdit=true&actorId=" + actor.getActorId() + "'>修改</a>");
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
