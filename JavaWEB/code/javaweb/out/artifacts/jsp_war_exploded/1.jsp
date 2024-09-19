<%@page contentType="text/html; charset=UTF-8"%>
<html>
    <head>
        <title>my first jsp page</title>
    </head>
    <body>
        <script>
            function sayHello(){
                alert("hello jsp, 张三")
            }
        </script>
        <h1>my first jsp page!!!</h1>
        <input type="button" value="hi jsp" onclick="sayHello()">
        <button onclick="sayHello()">按钮</button>
    </body>
</html>
