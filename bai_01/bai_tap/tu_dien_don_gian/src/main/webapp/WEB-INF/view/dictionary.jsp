<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 01/02/2023
  Time: 5:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ điển đơn giản</title>
</head>
<body>
<h1>Từ điển Anh - Việt</h1>
<form action="/translate" method="post">
    <label>Tiếng Anh </label>
    <input name="eng" placeholder="Nhập từ tiếng Anh" type="text">
    <label>Tiếng Việt </label>
    <input name="vie" type="text">
    <input type="submit" value="translate">
</form>
</body>
</html>
