<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>农家乐登陆</title>
    <style>
        #cont{
            width:300px;
            height: 200px;
            margin: 100px auto;
            border: solid  1px;
            padding-top: 50px;
        }
        form {
            margin: auto;
            text-align: center;
        }

        .line {
            margin-top: 20px;
        }

        .line input {
            width:150px;
        }

        a{
            position: relative;
            top: 20px;
            left: 100px;
        }

    </style>
</head>
<body>
<div id = "cont">
<sf:form commandName="hotelAccount" action="/hotelLogin/submit">
    <div class="line">
    用户名：
        <sf:input path="name"/>
        <p><span class = "errors">${errors}</span></p>
    </div>
    <div class="line">
    密码：&nbsp;&nbsp;
    <sf:password path="passwd"/>
        <p><span class = "errors">${errors}</span></p>
    </div>
    <div class="sub">
    <input type="submit" value="登录"/>&nbsp;&nbsp;
    <input type="button" value="取消"onclick="window.location.href='/hotel'"/>
    </div>
    <a href="/hotel">注册</a>
</sf:form>
</div>
</body>
</html>
