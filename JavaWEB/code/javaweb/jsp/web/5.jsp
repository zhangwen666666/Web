<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%
  // 向四个域中存储数据，name都相同
  session.setAttribute("data", "session");
  request.setAttribute("data", "request");
  application.setAttribute("data", "application");
  pageContext.setAttribute("data", "pageContext");
%>

${sessionScope.data}<br>
${requestScope.data}<br>
${pageScope.data}<br>
${applicationScope.data}<br>

<%
  request.setAttribute("username","zhangsan");
%>
<%=request.getAttribute("usernam")%><br><%--浏览器上显示null--%>
EL表达式:${usernam}<%--浏览器上什么也不现实，输出一个空字符串--%>

<hr>

<%
  Map<String, String> map = new HashMap<>();
  map.put("user.name", "zhangsan");
  map.put("password", "1234");
  request.setAttribute("map", map);
%>
${map["user.name"]};<br>
${map.password}