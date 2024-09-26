package com.javaweb.action;

import com.javaweb.bean.Actor;
import com.javaweb.dao.ActorDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet({"/actor/list", "/actor/detail", "/actor/add", "/actor/delete", "/actor/modify"})
public class ActorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        switch (servletPath) {
            case "/actor/list" -> doList(request, response);
            case "/actor/detail" -> doDetail(request, response);
            case "/actor/add" -> doAdd(request, response);
            case "/actor/delete" -> doDel(request, response);
            case "/actor/modify" -> doModify(request, response);
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
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }


    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int actorId = Integer.parseInt(request.getParameter("actorId"));
        ActorDao dao = new ActorDao();
        boolean deleted = dao.deleteById(actorId);
        if (deleted) {
            // out.print("删除成功");
            response.sendRedirect(request.getContextPath() + "/actor/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
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
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int actorId = Integer.parseInt(request.getParameter("actorId"));
        String isEdit = request.getParameter("isEdit");
        ActorDao dao = new ActorDao();
        Actor actor = dao.selectById(actorId);
        if (actor == null) {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        } else {
            // 查询到了id为actorId的演员信息，并封装到了对象actor中
            request.setAttribute("actor", actor);
            if ("true".equals(isEdit)) {
                request.getRequestDispatcher("/edit.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/detail.jsp").forward(request, response);
            }
        }
    }


    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // out.print("演员列表");
        ActorDao dao = new ActorDao();
        List<Actor> actorList = dao.selectAll();
        request.setAttribute("actorList", actorList);
        // 转发
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
