<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页码</title>
    <style>
        a {
            text-decoration: none;
        }

        .now {
            font-weight: bolder;
            color: #0E0D0D;
        }
    </style>
</head>
<body>
<div id="cont">

        <s:if test="${now != 1}">
            <a href="<s:url value = "${path}"><s:param name="pageNum" value="${now-1}"/></s:url>">上一页&nbsp;&nbsp;</a>
        </s:if>

        <s:forEach begin="${begin}" end="${end}" var="n">
            <s:if test="${n==now}">
                <a class="now" href="<s:url value="${path}"><s:param name="pageNum" value="${n}"/></s:url>">&nbsp;&nbsp;${n}&nbsp;&nbsp;</a>
            </s:if>
            <s:if test="${n!=now}">
                <a href="<s:url value="${path}"><s:param name="pageNum" value="${n}"/></s:url>">&nbsp;&nbsp;${n}&nbsp;&nbsp;</a>
            </s:if>
        </s:forEach>

        <s:if test="${now != end}">
            <a href="<s:url value="${path}"><s:param name="pageNum" value="${now+1}"/></s:url>">&nbsp;&nbsp;下一页</a>
        </s:if>

</div>
</body>
</html>
