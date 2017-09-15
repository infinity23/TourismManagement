<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>农家乐信息管理平台</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resourses/style.css"/>"/>
    <tiles:insertAttribute name="meta"/>
    <title:insertAttribute name="login"/>
</head>
<body>
<div id="header">
    <tiles:insertAttribute name="header"/>
</div>

<div id="content">
    <tiles:insertAttribute name="body"/>
</div>

<div id="footer">
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>