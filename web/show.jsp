<%@ page import="java.util.List" %>
<%@ page import="com.cs.entity.User" %>
<%@ page import="com.cs.service.impl.UserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/6
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table>
    <tr>
        <td>用户编号</td>
        <td>${us.id}</td>
    </tr>
    <tr>
        <td>用户姓名</td>
        <td>${us.username}</td>
    </tr>
    <tr>
        <td>用户密码</td>
        <td>${us.password}</td>
    </tr>
    <tr>
        <td>性别</td>
        <td>${us.sex}</td>
    </tr>
    <tr>
        <td>出生日期</td>
        <td>${us.bornDate}</td>
    </tr>
    <tr>
        <td>用户头像</td>
        <td>${us.userpic}</td>
    </tr>
</table>

</body>
</html>
