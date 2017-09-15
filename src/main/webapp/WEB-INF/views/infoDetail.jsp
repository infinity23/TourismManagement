<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息明细</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resourses/retrieval.css"/>"/>
</head>
<body>
<div id="result">
    <table class="info">
        <tr>
            <th colspan="7">入住信息</th>
        </tr>
        <tr>
            <th>旅馆名称</th>
            <th>姓名</th>
            <th>日期</th>
            <th>入住人数</th>
            <th>入住天数</th>
            <th>备注</th>
            <th>详情</th>
        </tr>
        <c:forEach var="info" items="${infos}">
            <tr>
                <td>${info.hotel.hotelName}</td>
                <td>${info.tourist.touristName}</td>
                <td>${info.checkIn}</td>
                <td>${info.number}</td>
                <td>${info.duration}</td>
                <td>${info.info}</td>
                <%--<td><a href="--%>
                    <%--<s:url value="/infoRetrieval/detail/{id}">--%>
                        <%--<s:param name="id" value="${hotel.id}"/>--%>
        <%--</s:url>">查看详情</a></td>--%>
            <%--</tr>--%>
        </c:forEach>
    </table>
</div>
</body>
</html>
