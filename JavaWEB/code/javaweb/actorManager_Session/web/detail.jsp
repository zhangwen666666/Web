<%@ page import="com.javaweb.bean.Actor" %>
<%@ page import="com.javaweb.bean.User" %>
<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <title>演员详情页面</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
%>
<h3>欢迎<%=user.getUsername()%>登录</h3>
<a href="<%=request.getContextPath()%>/user/exit">安全退出系统</a>
    <h1>演员详情</h1>
    <hr>
    <%
        Actor actor = (Actor) request.getAttribute("actor");
    %>
    演员编号: <%=actor.getActorId()%> <br>
    演员姓名: <%=actor.getActorName()%> <br>
    演员作品: <%=actor.getActorWork()%> <br>
    <input type='button' value='返回' onclick='window.history.back()'>
</body>
</html>