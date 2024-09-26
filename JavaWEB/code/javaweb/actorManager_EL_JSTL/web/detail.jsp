<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <title>演员详情页面</title>
</head>
<body>
<h3>欢迎${user.username}登录</h3>
<a href="${pageContext.request.contextPath}/user/exit">安全退出系统</a>
    <h1>演员详情</h1>
    <hr>
    演员编号: ${actor.actorId} <br>
    演员姓名: ${actor.actorName} <br>
    演员作品: ${actor.actorWork} <br>
    <input type='button' value='返回' onclick='window.history.back()'>
</body>
</html>