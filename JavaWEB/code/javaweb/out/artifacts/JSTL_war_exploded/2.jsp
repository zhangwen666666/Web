<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--没有else--%>
<c:if test="${empty param.username}">
    <h1>用户名不能为空</h1>
</c:if>
<%--if标签的test标签是必须的--%>
<%--if标签还有var属性，保存的是test属性的布尔类型的值，不是必须的--%>
<%--scope属性，用来指定var的存储域，也不是必须的--%>
<%--scope有四个值可选：page(pageContext域), request(request域), session(session域), application(application域)--%>
<c:if test="${not empty param.username}" var="v" scope="request">
    <h1>欢迎${param.username}登录</h1>
</c:if>

<hr>
<%--通过EL表达式将request域当中的v取出--%>
${v}