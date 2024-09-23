<%@ page import="com.javaweb.jstl.javabean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--var用来指定循环中的变量--%>
<%--begin开始，end结束，step步长--%>
<%--i可以使用EL表达式，说明i变量被放到了某个域当中(存储在了pageContext域中)--%>
<c:forEach var="i" begin="1" end="10" step="1">
    ${i}<br>
</c:forEach>

<%----%>
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
<%--varStatus这个属性表示var的状态对象，这是一个java对象，这个java对象代表了var的状态--%>
<%--varStatus这个状态属性有count属性，可以直接使用，count从1开始，以1递增，主要用于编号--%>
<c:forEach items="${stuList}" var="stu" varStatus="stuStatus">
    编号: ${stuStatus.count}, id: ${stu.id}, name: ${stu.name} <br>
</c:forEach>