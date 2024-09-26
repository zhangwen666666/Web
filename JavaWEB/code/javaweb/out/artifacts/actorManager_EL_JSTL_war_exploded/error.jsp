<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>错误页面</title>
</head>
<body>
<h3>欢迎${user.username}登录</h3>
<a href="${pageContext.request.contextPath}/user/exit">安全退出系统</a>
    <h1>操作失败</h1>
    <a href="${pageContext.request.contextPath}/actor/list">点击返回主页面</a>
</body>
</html>