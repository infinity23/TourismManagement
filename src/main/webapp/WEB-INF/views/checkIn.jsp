<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>旅客登记</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resourses/register.css"/>"/>
</head>
<body>
<div id="title">
    <h2>旅客入住登记</h2>
</div>
<div id="pic"></div>
<div id="mid">
    <sf:form commandName="info" action="/checkIn/submit" method="post">
        <table class="info">
            <tr>
                <td class="lable">
                    姓名：
                </td>
                <td>
                    <sf:input path="tourist.touristName"/>
                </td>
            </tr>
            <tr>
                <td class="lable">
                    年龄：
                </td>
                <td>
                    <sf:input path="tourist.age"/>
                </td>
            </tr>
            <tr>
                <td class="lable">
                    性别：
                </td>
                <td>
                    <sf:radiobutton path="tourist.gender" value="男"/>男
                    <sf:radiobutton path="tourist.gender" value="女"/>女
                </td>
            </tr>
            <tr>
                <td class="lable">
                    电话：
                </td>
                <td>
                    <sf:input path="tourist.phone"/>
                </td>
            </tr>
            <tr>
                <td class="lable">
                    公司：
                </td>
                <td>
                    <sf:input path="tourist.company"/>
                </td>
            </tr>
            <tr>
                <td class="lable">
                    住址：
                </td>
                <td>
                    <sf:input path="tourist.address"/>
                </td>
            </tr>
            <tr>
                <td class="lable">
                    身份证号：
                </td>
                <td>
                    <sf:input path="tourist.idcard"/>
                </td>
            </tr>
            <tr>
            <tr>
                <td class="lable">
                    入住人数：
                </td>
                <td>
                    <sf:input path="number"/>
                </td>
            </tr>
            <tr>
                <td class="lable">
                    入住天数：
                </td>
                <td>
                    <sf:input path="duration"/>
                </td>
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
