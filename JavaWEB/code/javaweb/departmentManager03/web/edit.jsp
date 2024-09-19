<%@ page import="com.javaweb.oa.bean.Dept" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%
    Dept dept = (Dept) request.getAttribute("dept");
%>
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <title>修改部门</title>
</head>
<body>
    <h1>修改部门</h1>
    <hr>
    <form action='<%=request.getContextPath()%>/dept/modify' method='post'>
        部门编号<input type='text' name='deptno' value='<%=dept.getDeptno()%>' readonly/><br>
        部门名称<input type='text' name='dname' value='<%=dept.getDname()%>'/><br>
        部门位置<input type='text' name='loc' value='<%=dept.getLoc()%>'/><br>
        <input type='submit' value='修改'/><br>
    </form>
</body>
</html>