<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 08/02/2023
  Time: 8:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous">
    </script>
</head>
<body>
<div class="row">
    <div class="col-2">
        <ul class="list-group vh-79 left-nav-scroll" style="height: 81%">
            <li class="list-group-item">Item 1</li>
            <li class="list-group-item">Item 2</li>
            <li class="list-group-item">Item 3</li>
            <li class="list-group-item">Item 4</li>
            <li class="list-group-item">Item 5</li>
            <li class="list-group-item">Item 6</li>
            <li class="list-group-item">Item 7</li>
            <li class="list-group-item">Item 8</li>
            <li class="list-group-item">Item 9</li>
            <li class="list-group-item">Item 10</li>
            <li class="list-group-item">Item 11</li>
            <li class="list-group-item">Item 12</li>
            <li class="list-group-item">Item 13</li>
            <li class="list-group-item">Item 14</li>
            <li class="list-group-item">Item 15</li>
        </ul>
    </div>
    <div class="col-10">
        <h1>Edit Settings</h1>
        <form:form modelAttribute="mailbox" action="/mailbox/edit" method="post">
            <table class="table table-light">
                <tr>
                    <td><form:hidden path="id"/></td>
                </tr>
                <tr>
                    <td>Languages:</td>
                    <td><form:select path="languages" items="${languages}"/></td>
                </tr>
                <tr>
                    <td>Pages size:</td>
                    <td>
                        <span>Show</span>
                        <form:select path="pageSize" items="${pageSize}"/>
                        <span>email per page.</span>
                    </td>
                </tr>
                <tr>
                    <td>Spams filter:</td>
                    <td>
                        <form:checkbox path="spamsFilter"/>
                        <span>Enable spams filter</span>
                    </td>
                </tr>
                <tr>
                    <td>Signature:</td>
                    <td><form:textarea path="signature"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><form:button type="submit" class="btn btn-primary">Edit</form:button></td>
                </tr>
            </table>
        </form:form>
        <a href="/mailbox/list">
            <button class="btn btn-secondary">Cancel</button>
        </a>
    </div>
</div>
</body>
</html>
