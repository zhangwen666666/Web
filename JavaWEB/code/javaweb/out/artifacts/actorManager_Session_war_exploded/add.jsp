<%@ page import="com.javaweb.bean.User" %>
<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新增演员页面</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
%>
<h3>欢迎<%=user.getUsername()%>登录</h3>
<a href="<%=request.getContextPath()%>/user/exit">安全退出系统</a>
    <form action="<%=request.getContextPath()%>/actor/add" method="post">
        演员编号: <input type="text" name="actorId"><br>
        演员姓名: <input type="text" name="actorName"><br>
        演员作品: <input type="text" name="actorWork"><br>
        <input type="submit" value="确定"><br>
    </form>
</body>
</html>