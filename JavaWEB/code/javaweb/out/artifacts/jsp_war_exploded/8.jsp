<%@page contentType="text/html;charset=UTF-8" %>

<%--注意：在EL表达式中"+"只能做求和运算，不会进行字符串拼接操作--%>
<%-- + 两边不是数字的时候，一定会转成数字，转不成数字就会报错--%>
${10 + 20}<br>  <%--30--%>
${10 + "20"}<br>  <%--30--%>
${"10" + "20"}<br>  <%--30--%>
\${'a' + 'b'}<br>

${empty param.password == null}<br>
${empty (param.password == null)}<br>
${(empty param.password) != null}<br>
${empty true}<br>
${empty false}<br>

