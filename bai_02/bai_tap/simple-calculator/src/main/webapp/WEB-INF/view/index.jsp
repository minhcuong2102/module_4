<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 03/02/2023
  Time: 8:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/result" method="post">
    <label>Nhập số thứ nhất: </label>
    <input type="number" name="num1" placeholder="Nhập số thứ nhất" value="${num1}"><br>
    <label>Nhập số thứ hai: </label>
    <input type="number" name="num2" placeholder="Nhập số thứ hai" value="${num2}"><br>
    <label>Kết quả: </label>
    <input type="number" name="result" placeholder="Kết quả" value="${result}"><br><br>
    <input type="submit" name="calculation" value="Addition(+)">
    <input type="submit" name="calculation" value="Subtraction(-)">
    <input type="submit" name="calculation" value="Multiplication(*)">
    <input type="submit" name="calculation" value="Division(/)">
</form>
</body>
</html>
