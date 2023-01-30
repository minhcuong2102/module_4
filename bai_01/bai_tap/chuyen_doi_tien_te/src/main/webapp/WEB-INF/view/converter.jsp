<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 13/01/2023
  Time: 8:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
</head>
<body>
<form method="post" action="/chuyen-doi">
    <label>USD: </label>
    <input name="usd" value="0" type="text">
    <label>Rate: </label>
    <input name="rate" value="23000" type="text" readonly>
    <input type="submit" value="Convert">
</form>
</body>
</html>
