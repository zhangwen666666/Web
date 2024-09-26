<%@ page import="com.javaweb.bean.Actor" %>
<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <title>演员详情页面</title>
</head>
<body>
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