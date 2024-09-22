<%@page contentType="text/html;charset=UTF-8"%>

应用的根路径: ${pageContext.request.contextPath}<br>

<%--用户在浏览器上提交数据:http://localhost:8080/jsp/7.jsp?username=zhangsan--%>
用户名: <%=request.getParameter("username")%><br> <%--获取到的是zhangsan--%>
用户名: ${param.username}<br>  <%--获取到的是zhangsan--%>

<%--用户在浏览器上提交数据:http://localhost:8080/jsp/7.jsp?hobby=smoke&hobby=drink&hobby=tangtou--%>
<%--以上提交的数据显然是采用checkbox进行提交的，同一组的checkbox的name是一样的--%>
爱好: <%=request.getParameter("hobby")%><br>  <%--获取到的是smoke--%>
爱好: ${param.hobby}<br>  <%--获取到的是smoke--%>
<hr>
爱好: <%=request.getParameterValues("hobby")%><br>    <%--爱好: [Ljava.lang.String;@73b88f33--%>
爱好: ${paramValues.hobby}<br>    <%--爱好: [Ljava.lang.String;@7d7f6f34--%>
爱好: ${paramValues.hobby[0]}, ${paramValues.hobby[1]}, ${paramValues.hobby[2]}<br>
<%--爱好: smoke, drink, tangtou--%>
<hr>

<%--initParam获取的是web.xml文件中Servlet上下文的初始化参数(context-param标签)--%>
<%--在java程序中需要使用ServletContext对象来获取  对应JSP的九大内置对象之一：application--%>
pageSize: <%=request.getServletContext().getInitParameter("pageSize")%><br>
pageNum: <%=request.getServletContext().getInitParameter("pageNum")%><br>
pageSize: <%=application.getInitParameter("pageSize")%><br>
pageNum: <%=application.getInitParameter("pageNum")%><br>
pageSize: ${initParam.pageSize}<br>
pageNum: ${initParam.pageNum}