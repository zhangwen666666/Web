<%@ page import="java.util.List" %>
<%@ page import="com.javaweb.oa.bean.Dept" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <title>部门列表页面</title>
</head>
<body>
    <script type="text/javascript">
        function del(dno){
            if(window.confirm("亲，删除了之后不可恢复哦!!!")) {
                document.location.href="dept/delete?deptno=" + dno
            }
        }   
    </script>

    <h3>欢迎${user.username}登录</h3>
    <h3>当前在线人数：${count}</h3>
    <a href="user/exit">[退出系统]</a>

    <h1 align="center">部门列表</h1>
    <hr>
    <table border="1px" align="center" width="50%" >
        <tr>
            <th>序号</th>
            <th>部门编号</th>
            <th>部门名称</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${deptList}" var="dept" varStatus="deptStatus">
            <tr align="center">
                <td>${deptStatus.count}</td>
                <td>${dept.deptno}</td>
                <td>${dept.dname}</td>
                <td>
                    <a href="javascript:void(0)" onclick="del(${dept.deptno})">删除</a>
                        <%--<a href="<%=request.getContextPath()%>/dept/edit?deptno=<%=dept.getDeptno()%>">修改</a>--%>
                        <%--修改和详情公用一个页面 多传递一个参数f，修改数据时改参数值为m，查看详情时该参数值为d--%>
                    <a href="dept/detail?f=m&deptno=${dept.deptno}">修改</a>
                    <a href="dept/detail?f=d&deptno=${dept.deptno}">详情</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <hr>
    <h4><a href="add.jsp">点击新增部门</a></h4>
</body>
</html>