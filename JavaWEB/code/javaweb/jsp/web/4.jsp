<%@ page import="bean.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    User user = new User();
    user.setAge(18);
    user.setPassword("123");
    user.setUsername("zhangsan");
    user.setSex(true);
    request.setAttribute("user", user);
%>

${user}
<br>
${user.sex}
<br>
${user.age}
