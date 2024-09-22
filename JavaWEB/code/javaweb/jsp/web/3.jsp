<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%
  // 向request域当中存储username为zhangsan
  request.setAttribute("username", "zhangsan");
%>

<%--将request域当中的数据取出来，并且输出到浏览器上，使用java代码怎么办--%>
<%=request.getAttribute("username")%>
<%--使用EL表达式--%>
${username}

