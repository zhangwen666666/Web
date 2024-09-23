<%@ page import="com.javaweb.jstl.javabean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html;charset=UTF-8" %>

<%--引入标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    List<Student> stuList = new ArrayList<>();
    Student s1 = new Student("111", "警察");
    Student s2 = new Student("222", "小偷");
    Student s3 = new Student("333", "美女");
    stuList.add(s1);
    stuList.add(s2);
    stuList.add(s3);
    request.setAttribute("stuList", stuList);
%>

<%--使用java代码遍历集合--%>
<%
    List<Student> stuList1 = (List<Student>) request.getAttribute("stuList");
    for (Student student: stuList1){
%>
        id:<%=student.getId()%>, name:<%=student.getName()%><br>
<%
    }
%>

<%--使用core标签库中的forEach标签，对List集合进行遍历--%>
<c:forEach items="${stuList}" var="stu">
    id: ${stu.id}, name: ${stu.name} <br>
</c:forEach>