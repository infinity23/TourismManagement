<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>


<html>
<head>
    <title>游客信息</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resourses/register.css"/>"/>
</head>
<body>
<div id="title">
    <h2>游客信息录入</h2>
</div>
<div id="pic"></div>
<div id="mid">
<sf:form method="post" commandName="tourist" action="/touristRegister/submit">
    <table class="info">
        <tr>
            <td class="lable">
                姓名：
            </td>
            <td>
                <sf:input path="touristName"/>
            </td>
        </tr>
        <tr>
            <td class="lable">
                年龄：
            </td>
            <td>
                <sf:input path="age"/>
            </td>
        </tr>
        <tr>
            <td class="lable">
                性别：
            </td>
            <td>
                <sf:radiobutton path="gender" value="男"/>男
                <sf:radiobutton path="gender" value="女"/>女
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
                公司：
            </td>
            <td>
                <sf:input path="company"/>
            </td>
        </tr>
        <tr>
            <td class="lable">
                住址：
            </td>
            <td>
                <sf:input path="address"/>
            </td>
        </tr>
        <tr>
            <td class="lable">
                身份证号：
            </td>
            <td>
                <sf:input path="idcard"/>
            </td>
        </tr>
        <tr>
        <tr>
            <td class="lable">
                备注：
            </td>
            <td>
                <sf:textarea path="info"/>
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