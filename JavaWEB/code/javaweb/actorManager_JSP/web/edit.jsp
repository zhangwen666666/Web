<%@ page import="com.javaweb.bean.Actor" %>
<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改演员信息页面</title>
</head>
<body>
    <h1>修改演员信息页面</h1>
    <%
        Actor actor = (Actor) request.getAttribute("actor");
    %>
    <form action="<%=request.getContextPath()%>/actor/modify" method="post">
        演员编号<input type="text" name="actorId" value="<%=actor.getActorId()%>" readonly><br>
        演员姓名<input type="text" name="actorName" value="<%=actor.getActorName()%>"> <br>
        演员作品<input type="text" name="actorWork" value="<%=actor.getActorWork()%>"> <br>
        <input type="submit" value="修改"><br>
    </form>
</body>
</html>