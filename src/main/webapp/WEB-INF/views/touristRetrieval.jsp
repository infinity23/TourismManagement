<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>游客检索</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resourses/retrieval.css"/>"/>
</head>
<body>
<div id="cond">
    条件检索：
    <sf:form commandName="retrievalCondition" method="post" action="/touristRetrieval/byCondition">
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
        <th colspan="5">游客信息检索</th>
    </tr>
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>电话</th>
        <th>详细信息</th>
    </tr>
    <c:forEach var="tourist" items="${tourists}">
        <tr>
            <td>${tourist.touristName}</td>
            <td>${tourist.gender}</td>
            <td>${tourist.age}</td>
            <td>${tourist.phone}</td>
            <td><a href="
                    <s:url value="/infoRetrieval/detail/{id}">
                        <s:param name="id" value="${hotel.id}"/>
        </s:url>">查看详情</a></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
