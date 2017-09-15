<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误信息</title>
    <script type="text/javascript">
        function resize()
        {
            window.resizeTo(200, 300);
            window.moveTo(300, 400);
        }

    </script>
</head>
<body onload="alert('${info}')">
<%--<h1>${info}</h1>--%>
</body>
</html>
