<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<html>
<head>
    <title>信息录入</title>
    <style type="text/css">
        table.info {
            margin-left: 35%;
            width: 40%;
            border: 1px;
            text-align: center;
            border-collapse: collapse;
        }

        .info td {
            border: 1px;
            height: 35px;
            width: auto;
            text-align: left;
        }

        td.lable {
            text-align: center;
            width: 100px;
        }

        .button input {
            position: relative;
            left: 100px;
        }

        span.error {
            margin-left: 10px;
            font: italic 300 80% "errors";
            color: red;
        }
    </style>
</head>
<body>
<sf:form method="post" modelAttribute="info" commandName="info" action="/infoEntry/register">
    <table class="info">
        <tr>
            <td class="lable">
                旅馆名称：
            </td>
            <td>
                <sf:input path="hotel"/><sf:errors path="hotel" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td class="lable">
                姓名：
            </td>
            <td>
                <sf:input path="name"/><sf:errors path="name" cssClass="error"/>
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
                <sf:radiobutton path="gender" value="male"/>男
                <sf:radiobutton path="gender" value="female"/>女
            </td>
        </tr>
        <tr>
            <td class="lable">
                电话：
            </td>
            <td>
                <sf:input path="cellphone"/>
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
                <sf:input path="idcard"/><sf:errors path="idcard" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td class="lable">
                备注：
            </td>
            <td>
                <sf:textarea path="remark"/>
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
</body>
</html>