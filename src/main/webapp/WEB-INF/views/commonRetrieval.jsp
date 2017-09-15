<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>检索</title>
    <style>
        #cont{
            margin-top: 50px;
        }

        .val{
            width: 300px;
            height: 30px;
        }

        .but{
            width: 50px;
            height: 30px;
        }

        select{
            width: 60px;
            height: 30px;
        }


    </style>
</head>
<body>
<h1>${title}</h1>
<div id="cont">
<sf:form action="${path}/page?pageNum=1" commandName="retrievalCondition">
    <sf:input cssClass="val" path="value"/>
    <sf:select path="condition">
        <sf:option value="all">全部</sf:option>
        <sf:option value="byName">名称</sf:option>
        <sf:option value="byName">地址</sf:option>
        <sf:option value="byName">电话</sf:option>
        <sf:option value="byName">身份证号</sf:option>
    </sf:select>
    <input class="but" type="submit" value="检索"/>
</sf:form>
</div>
</body>
</html>
