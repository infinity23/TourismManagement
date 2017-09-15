<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resourses/register.css"/>"/>
    <title>农家乐信息</title>
</head>
<body>
<div id="title">
    <h2>农家乐信息录入</h2>
</div>
<div id="pic"></div>
<div id="mid">
<sf:form method="post" commandName="hotel">
    <table class="info">
        <tr>
            <td class="lable">
                旅馆名称：
            </td>
            <td>
                <sf:input path="hotelName"/>
            </td>
        </tr>
        <tr>
            <td class="lable">
                地址：
            </td>
            <td>
                <sf:input path="address"/>
            </td>
        </tr>
        <tr>
            <td class="lable">
                电话：
            </td>
            <td>
                <sf:input path="phone"/>
            </td>
        </tr>
        <tr>
            <td class="lable">
                法人：
            </td>
            <td>
                <sf:input path="hostName" />
            </td>
        </tr>
        <tr>
            <td class="lable">
                身份证：
            </td>
            <td>
                <sf:input path="idcard"/>
            </td>
        </tr>
        <%--<tr>--%>
            <%--<td class="lable">--%>
                <%--身份证照片：--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--&lt;%&ndash;<sf:input />&ndash;%&gt;--%>
            <%--</td>--%>
        <%--</tr>--%>
        <tr>
            <td class="lable">
                备注：
            </td>
            <td>
                <sf:textarea  path="info"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="button">
                <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;
                <input type="button" value="取消" onclick="window.location.href='/'">
            </td>
        </tr>
    </table>
</sf:form>
</div>
<div id="idpic"><span class="title">身份证照片</span></div>
</body>
</html>