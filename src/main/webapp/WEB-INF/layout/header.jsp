<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resourses/header.css"/>"/>
</head>
<body>
<div id="banner" onclick="window.location.href='/'" style="background: url('/resourses/image/logo5(police).png')
no-repeat center;background-size: 100% 100%;"></div>
<li class="nav">信息录入
    <ul class="pull_down">
        <li><a href="${pageContext.request.contextPath}/hotelRegister">农家乐信息</a></li>
        <li><a href="${pageContext.request.contextPath}/touristRegister">游客信息</a></li>
    </ul>
</li>
<li class="nav">信息检索
    <ul class="pull_down">
        <li><a href="${pageContext.request.contextPath}/hotelRetrieval">农家乐检索</a></li>
        <li><a href="${pageContext.request.contextPath}/touristRetrieval">游客检索</a></li>
        <li><a href="${pageContext.request.contextPath}/infoRetrieval">入住检索</a></li>
    </ul>
</li>
<%--<li class="nav">入住登记--%>
    <%--<ul class="pull_down">--%>
        <%--<li><a href="${pageContext.request.contextPath}/checkIn2">入住登记</a></li>--%>
        <%--<li><a href="${pageContext.request.contextPath}/infoRetrieval">入住检索</a></li>--%>
    <%--</ul>--%>
<%--</li>--%>

<security:authorize access="!hasRole('ADMIN')">
<div class="log">
    <%--<a href="<s:url value="/"/>">注册</a>--%>
    <a href="<s:url value="javascript:window.open('/login','_blank','height=210, width =320, top=300, left=400','menubar=no,scrollbars=no,toolbar=no,resizable=no,location=no,status=no')"/>">登录</a>
</div>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
<div class="log">
    欢迎，<a href="<s:url value="/"/>"><security:authentication property="principal.username"/></a>
    <div style="display: none">
    <sf:form action="/logout" id="logout" method="post">
    </sf:form>
    </div>
    <a href="#" onclick="document.getElementById('logout').submit();">退出</a>
</div>
</security:authorize>
</body>
</html>

