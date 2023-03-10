<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 07/02/2023
  Time: 2:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Settings</title>
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
        <h1 class="text-center">List Settings</h1>
        <p class="text-danger">${mess}</p>
        <h2>
            <a href="/mailbox/settings">
                <button class="btn btn-primary">Settings</button>
            </a>
        </h2>
        <table class="table table-striped">
            <tr>
                <th>No.</th>
                <th>Id</th>
                <th>Language</th>
                <th>Page Size</th>
                <th>Spams filter</th>
                <th>Signature</th>
                <th>Update</th>
            </tr>
            <c:forEach var="setting" items="${settingList}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${setting.id}</td>
                    <td>${setting.languages}</td>
                    <td>${setting.pageSize}</td>
                    <td>${setting.spamsFilter}</td>
                    <td>${setting.signature}</td>
                    <td><a href="/mailbox/edit?id=${setting.id}"><button class="btn btn-primary">Edit</button></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
