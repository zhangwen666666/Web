<%@ page import="com.javaweb.bean.Actor" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html;charset=UTF-8" %>

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
            window.location.href = "<%=request.getContextPath()%>/actor/delete?actorId=" + actorId
        }
    }
</script>
<h1 align="center">演员列表</h1>
<hr>
<table border="1px" width="50%" align="center">
    <tr align="center">
        <th>序号</th>
        <th>演员编号</th>
        <th>姓名</th>
        <th>操作</th>
    </tr>

    <%
        List<Actor> actorList = (List<Actor>) request.getAttribute("actorList");
        for (int i = 1; i <= actorList.size(); i++) {
            Actor actor = actorList.get(i - 1);
    %>
    <tr align="center">
        <td><%=i%></td>
        <td><%=actor.getActorId()%></td>
        <td><%=actor.getActorName()%></td>
        <td>
            <a href="javascript:void(0)" onclick="del(<%=actor.getActorId()%>)">删除</a>
            <a href="<%=request.getContextPath()%>/actor/detail?isEdit=true&actorId=<%=actor.getActorId()%>">修改</a>
            <a href="<%=request.getContextPath()%>/actor/detail?actorId=<%=actor.getActorId()%>">详情</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
<hr>
<h3>
    <a href="<%=request.getContextPath()%>/add.jsp">点击新增演员</a>
</h3>
</body>
</html>