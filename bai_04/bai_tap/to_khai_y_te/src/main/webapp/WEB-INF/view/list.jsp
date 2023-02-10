<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 09/02/2023
  Time: 8:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tờ khai y tế</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous">
    </script>
</head>
<body>
<div class="row">
    <div class="col-2"></div>
    <div class="col-8">
        <h1 class="text-center">Tờ khai y tế</h1>
        <a href="/tkyt/create"><button class="btn btn-primary">Thêm tờ khai</button></a>
        <p class="text-danger">${mess}</p>
        <table class="table table-striped">
            <tr>
                <th>STT</th>
                <th>Họ tên</th>
                <th>Năm sinh</th>
                <th>Giới tính</th>
                <th>Quốc gia</th>
                <th>CMND</th>
                <th>Thông tin đi lại</th>
                <th>Số hiệu phương tiện</th>
                <th>Số ghế</th>
                <th>Ngày khởi hành</th>
                <th>Ngày kết thúc</th>
            </tr>

                <c:forEach var="tkyt" items="${toKhaiYTe}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${tkyt.name}</td>
                        <td>${tkyt.yearOfBirth}</td>
                        <c:if test="${tkyt.gender}">
                            <td>Nam</td>
                        </c:if><c:if test="${!tkyt.gender}">
                        <td>Nữ</td>
                    </c:if>
                        <td>${tkyt.nationality}</td>
                        <td>${tkyt.cmnd}</td>
                        <td>${tkyt.transportation}</td>
                        <td>${tkyt.vehicleId}</td>
                        <td>${tkyt.seat}</td>
                        <td>${tkyt.startDay}/${tkyt.startMonth}/${tkyt.startYear}</td>
                        <td>${tkyt.endDay}/${tkyt.endMonth}/${tkyt.endYear}</td>
                    </tr>
                </c:forEach>
        </table>
    </div>
    <div class="col-2"></div>
</div>
</body>
</html>
