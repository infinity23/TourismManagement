<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>closeLogin</title>
    <script type="text/javascript">
            function login()
            {
                window.opener.location.reload();
                window.close();
            } 　
        window.onload = login;
    </script>
</head>
<body>
</body>
</html>
