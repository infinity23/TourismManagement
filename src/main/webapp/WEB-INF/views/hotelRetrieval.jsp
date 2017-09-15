<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>农家乐检索</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resourses/retrieval.css"/>"/>
</head>
<body>
<div id="cond">
    条件检索：
    <sf:form commandName="retrievalCondition" method="post" action="/hotelRetrieval/page">
        <table>
            <tr>
                <td>
                    <sf:select path="condition">
                        <sf:option value="byName">名称</sf:option>
                        <sf:option value="byName">地址</sf:option>
                        <sf:option value="byName">电话</sf:option>
                        <sf:option value="byName">身份证号</sf:option>
                    </sf:select>
                </td>
            </tr>
            <tr>
                <td>
                    <sf:input path="value"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="搜索" />
                </td>
            </tr>
        </table>
    </sf:form>
</div>
<div id="result">
<table class="info">
    <tr>
        <th colspan="5">农家乐信息检索</th>
    </tr>
    <tr>
        <th>名称</th>
        <th>地址</th>
        <th>电话</th>
        <th>法人</th>
        <th>详细信息</th>
    </tr>
    <c:forEach var="hotel" items="${hotels}">
        <tr>
            <td>${hotel.hotelName}</td>
            <td><a href="<s:url value="javascript:window.open('/map?address=${hotel.address}'
            ,'_blank','height=600, width =800, top=100, left=200','menubar=no,scrollbars=no,toolbar=no, resizable=no,location=no, status=no')">
                                    </s:url>">${hotel.address}</a></td>
            <%--<td>${hotel.address}</td>--%>
            <td>${hotel.phone}</td>
            <td>${hotel.hostName}</td>
            <td><a href="
                    <s:url value="/hotelRetrieval/detail/{id}">
                        <s:param name="id" value="${hotel.id}"/>
        </s:url>">查看详情</a></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
