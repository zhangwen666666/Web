<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%
    String[] usernames = {"zhangsan","lisi", "wangwu"};
    request.setAttribute("usernames", usernames);
%>
${usernames}
${usernames[0]}
${usernames[1]}
${usernames[2]}
最后一个${usernames[100]} <%--不会出现越界异常，浏览器上输出一个空字符串--%>
<%=((HttpServletRequest)(pageContext.getRequest())).getContextPath()%>
${pageContext.request.contextPath}