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
    <h2>农家乐信息详情</h2>
</div>
<div id="pic"></div>
<div id="mid">
    <table class="info">
        <tr>
            <td class="lable">
                旅馆名称：
            </td>
            <td>
                ${hotel.hotelName}
            </td>
        </tr>
        <tr>
            <td class="lable">
                地址：
            </td>
            <td>
                ${hotel.address}<input type="button" value="在地图中查看" style="width:80px;height:18px; font-size: x-small"
                                       onclick="window.open('/map?address=${hotel.address}','_blank','height=600, width =800, top=100, left=200','menubar=no,scrollbars=no,toolbar=no, resizable=no,location=no, status=no')">

            </td>
        </tr>
        <tr>
            <td class="lable">
                电话：
            </td>
            <td>
                ${hotel.phone}
            </td>
        </tr>
        <tr>
            <td class="lable">
                法人：
            </td>
            <td>
                ${hotel.hostName}
            </td>
        </tr>
        <tr>
            <td class="lable">
                身份证：
            </td>
            <td>
                ${hotel.idcard}
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
                ${hotel.info}
            </td>
        </tr>
        <tr>
            <td colspan="2" class="button">
                <input type="button" value="修改" onclick="window.location.href='/hotelRetrieval/modify/${hotel.id}'">&nbsp;&nbsp;&nbsp;
                <input type="button" value="返回" onclick="window.location.href='/hotelRetrieval'">
            </td>
        </tr>
    </table>
</div>
<div id="idpic"><span class="title">身份证照片</span></div>
</body>
</html>