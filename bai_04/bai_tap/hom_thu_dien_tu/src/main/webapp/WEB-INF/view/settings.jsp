<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 06/02/2023
  Time: 7:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Cấu hình hòm thư</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous">
    </script>
</head>
<body>
<h1>Settings</h1>
<form:form method="post" action="/settings" modelAttribute="mailboxSettings">
    <table class="table table-striped">
        <tr>
            <td>
                Languages:
            </td>
            <td>
                <form:select path="languages">
                    <form:options items="${languages}">

                    </form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                Page sizes:
            </td>
            <td>
                Show <form:select path="pageSize">
                <form:options items="${pageSize}">

                </form:options>
            </form:select> emails per page.
            </td>
        </tr>
        <tr>
            <td>
                Spams filter:
            </td>
            <td>
                <form:checkbox path="spamsFilter"/>Enable spams filter
            </td>
        </tr>
        <tr>
            <td>
                Signature:
            </td>
            <td>
                <form:textarea path="signature"></form:textarea>
            </td>
        </tr>
    </table>
    <form:button type="submit">Update</form:button>
    <a href="/settings">Cancel</a>
</form:form>
</body>
</html>
