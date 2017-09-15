<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resourses/login.css"/>"/>
</head>
<body>
<sf:form commandName="user">
    <p class="inp">
        <label class="inline">用户名</label>
        <sf:input path="username"/>
        <span>${duplicateuser}</span>
    </p>
    <p class="inp">
        <label class="inline">密码&nbsp;&nbsp;</label>
        <sf:password path="password"/>
    </p>
    <p>
        <input class="button" type="submit" value="注册" />
    </p>
</sf:form>
</body>
</html>
