<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>演员列表页面</title>
</head>
<body>
<script>
    function del(actorId) {
        if (window.confirm("亲, 删了不可恢复哦!!!")) {
            window.location.href = "${pageContext.request.contextPath}/actor/delete?actorId=" + actorId
        }
    }
</script>
<h3>欢迎${user.username}登录</h3>
<a href="${pageContext.request.contextPath}/user/exit">安全退出系统</a>
<h1 align="center">演员列表</h1>
<hr>
<table border="1px" width="50%" align="center">
    <tr align="center">
        <th>序号</th>
        <th>演员编号</th>
        <th>姓名</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${actorList}" var="actor" varStatus="actStatus">
        <tr align="center">
            <td>${actStatus.count}</td>
            <td>${actor.actorId}</td>
            <td>${actor.actorName}</td>
            <td>
                <a href="javascript:void(0)" onclick="del(${actor.actorId})">删除</a>
                <a href="${pageContext.request.contextPath}/actor/detail?isEdit=true&actorId=${actor.actorId}">修改</a>
                <a href="${pageContext.request.contextPath}/actor/detail?actorId=${actor.actorId}">详情</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<h3>
    <a href="${pageContext.request.contextPath}/add.jsp">点击新增演员</a>
</h3>
</body>
</html>