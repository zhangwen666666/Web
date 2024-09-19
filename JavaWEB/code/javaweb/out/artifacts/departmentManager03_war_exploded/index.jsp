<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欢迎使用oa系统</title>
</head>
<body>
    <%--前端发送请求路径时，如果请求路径是绝对路径，需要以 / 开始，加项目名--%>
<%--    <a href="/oa/list.jsp">查看部门列表</a>--%>
<%--    <a href="<%=request.getContextPath()%>/list.jsp">查看部门列表</a>--%>
    <%--执行一个Servlet，查询数据库，收集数据--%>
    <a href="<%=request.getContextPath()%>/dept/list">查看部门列表</a>
</body>
</html>