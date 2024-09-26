<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欢迎使用演员管理系统</title>
</head>
<body>
    <h1>actorManager_Session</h1>
<%--    <a href="<%=request.getContextPath()%>/actor/list">点击查看演员列表</a>--%>
    <h3>欢迎使用演员管理系统</h3>
    <h3>请登录</h3>
    <form action="<%=request.getContextPath()%>/user/login" method="post">
        用户名: <input type="text" placeholder="请输入用户名" name="username"><br>
        密码: <input type="password" name="password"><br>
        三天内免登录: <input type="checkbox" name="loginFree" value="true"><br>
        <input type="submit" value="登录"><br>
    </form>
</body>
</html>