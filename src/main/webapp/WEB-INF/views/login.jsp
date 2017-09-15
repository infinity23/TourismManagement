<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resourses/login.css"/>"/>
    <script>
        function toRegister() {
            var seg = window.opener.location.pathname.split('/');
            var tail = seg[seg.length - 1];
            if(tail==='hotel') window.location.href="/hotel/register";
            else window.location.href="/register";
        }
    </script>
</head>
<body>
<sf:form commandName="user" action="/login">
    <p class="inp">
        <label class="inline">用户名</label>
        <sf:input path="username"/>
        <span>${usernotfound}</span>
    </p>
    <p class="inp">
        <label class="inline">密码&nbsp;&nbsp;</label>
        <sf:password path="password"/>
        <span>${passworderror}</span>
    </p>
    <p class="status">
        <label class="inline">保存状态</label>
        <input type="checkbox" name="remember-me-1" id="remember_me_1"/>
        <label class="inline" for="remember_me_1">一天</label>
        <input type="checkbox" name="remember-me-3" id="remember_me_3"/>
        <label class="inline" for="remember_me_3">三天</label>
        <input type="checkbox" name="remember-me-7" id="remember_me_7"/>
        <label class="inline" for="remember_me_7">一周</label>
        <input type="checkbox" name="remember-me-14" id="remember_me_14"/>
        <label class="inline" for="remember_me_14">两周</label>
    </p>
    <p>
        <input class="button" type="submit" value="登录" />
        <a href=javascript:toRegister()>点此注册</a>
    </p>
</sf:form>
</body>
</html>
