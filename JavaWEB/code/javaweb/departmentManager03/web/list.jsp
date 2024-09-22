<%@ page import="java.util.List" %>
<%@ page import="com.javaweb.oa.bean.Dept" %>
<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>部门列表页面</title>
</head>
<body>
    <script type="text/javascript">
        function del(dno){
            if(window.confirm("亲，删除了之后不可恢复哦!!!")) {
                document.location.href="<%=request.getContextPath()%>/dept/delete?deptno=" + dno
            }
        }   
    </script>

    <h1>欢迎<%=session.getAttribute("username")%>登录</h1>
    <a href="<%=request.getContextPath()%>/user/exit">[退出系统]</a>

    <h1 align="center">部门列表</h1>
    <hr>
    <table border="1px" align="center" width="50%" >
        <tr>
            <th>序号</th>
            <th>部门编号</th>
            <th>部门名称</th>
            <th>操作</th>
        </tr>

        <%
            // 从request域当中取出集合
            List<Dept> deptList = (List<Dept>)request.getAttribute("deptList");
            // 循环遍历
            int i = 0;
            for(Dept dept:deptList){
                // System.out.println(dept.getDeptno());
                // out.write(dept.getDeptno() + "<br>");
        %>
                <tr align="center">
                    <td><%=++i%></td>
                    <td><%=dept.getDeptno()%></td>
                    <td><%=dept.getDname()%></td>
                    <td>
                        <a href="javascript:void(0)" onclick="del(<%=dept.getDeptno()%>)">删除</a>
                        <%--<a href="<%=request.getContextPath()%>/dept/edit?deptno=<%=dept.getDeptno()%>">修改</a>--%>
                        <%--修改和详情公用一个页面 多传递一个参数f，修改数据时改参数值为m，查看详情时该参数值为d--%>
                        <a href="<%=request.getContextPath()%>/dept/detail?f=m&deptno=<%=dept.getDeptno()%>">修改</a>
                        <a href="<%=request.getContextPath()%>/dept/detail?f=d&deptno=<%=dept.getDeptno()%>">详情</a>
                    </td>
                </tr>
        <%
            }
        %>

    </table>

    <hr>
    <h4><a href="<%=request.getContextPath()%>/add.jsp">点击新增部门</a></h4>
</body>
</html>