<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改演员信息页面</title>
</head>
<body>
<h3>欢迎${user.username}登录</h3>
<a href="${pageContext.request.contextPath}/user/exit">安全退出系统</a>
    <h1>修改演员信息页面</h1>
    <form action="${pageContext.request.contextPath}/actor/modify" method="post">
        演员编号<input type="text" name="actorId" value="${actor.actorId}" readonly><br>
        演员姓名<input type="text" name="actorName" value="${actor.actorName}"> <br>
        演员作品<input type="text" name="actorWork" value="${actor.actorWork}"> <br>
        <input type="submit" value="修改"><br>
    </form>
</body>
</html>