<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<html>
<head>
    <title>入住查询</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resourses/retrieval.css"/>"/>
</head>
<body>
<table class="info">
    <tr>
        <th colspan="4">入住查询</th>
    </tr>
    <tr>
        <th>入住时间</th>
        <th>旅客姓名</th>
        <th>旅馆名称</th>
        <th>详细信息</th>
    </tr>
    <c:forEach var="info" items="${infoList}">
        <tr>
            <td><fmt:formatDate value="${info.checkIn}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${info.tourist.touristName}</td>
            <td>${info.hotel.hotelName}</td>
                <%--<td><a href="--%>
                <%--<s:url value="/infoRetrieval/detail/{id}">--%>
                <%--<s:param name="id" value="${info.value.id}"/>--%>
                <%--</s:url>">查看详情</a></td>--%>
            <td>查看详情</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
