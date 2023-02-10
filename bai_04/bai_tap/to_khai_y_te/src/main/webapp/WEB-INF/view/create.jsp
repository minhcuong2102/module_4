<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 09/02/2023
  Time: 8:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Tờ khai y tế</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous">
    </script>
    <style>
        .w-33 {
            width: 33.33%;
        }
    </style>
</head>
<body>
<div class="row">
    <div class="col-2"></div>
    <div class="col-8">
        <div class="text-center">
            <h4>TỜ KHAI Y TẾ</h4>
            <h5>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
                DỊCH BỆNH TRUYỀN NHIỄM</h5>
            <p class="text-danger">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự.</p>
        </div>
        <form:form action="/tkyt/create" method="post" modelAttribute="toKhaiYTe">
            <span>Họ tên (ghi chữ IN HOA) <span class="text-danger fst-italic">(*)</span></span>
            <form:input path="name" cssClass="w-100" required="required"/><br><br>
            <div class="w-100" style="display:flex">
                <div class="w-33">
                    <span>Năm sinh </span>
                    <span class="text-danger fst-italic">(*)</span>
                    <form:select path="yearOfBirth" cssClass="w-100">
                        <form:options items="${year}"/>
                    </form:select>
                </div>

                <div class="w-33">
                    <span>Giới tính </span>
                    <span class="text-danger fst-italic">(*)</span>
                    <form:select path="gender" cssClass="w-100">
                        <form:option value="true">Nam</form:option>
                        <form:option value="false">Nữ</form:option>
                    </form:select>
                </div>

                <div class="w-33">
                    <span>Quốc gia </span>
                    <span class="text-danger fst-italic">(*)</span>
                    <form:select path="nationality" cssClass="w-100">
                        <form:options items="${nationality}"/>
                    </form:select>
                </div>
                <br><br>
            </div>
            <span>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span class="text-danger fst-italic">(*)</span></span>
            <form:input path="cmnd" cssClass="w-100"/><br>
            <span>Thông tin đi lại <span class="text-danger fst-italic">(*)</span></span><br>
            <form:radiobuttons path="transportation" items="${transportation}" required="required"/><br><br>
            <div class="w-100" style="display:flex">
                <div class="w-50">
                    <span>Số hiệu phương tiện</span>
                    <form:input path="vehicleId" cssClass="w-100"/>
                </div>
                <div class="w-50">
                    <span>Số ghế</span>
                    <form:input path="seat" cssClass="w-100"/>
                </div>
            </div>
            <br>
            <div class="w-100 row" style="display:flex">
                <div class="col-6">
                    <span>Ngày khời hành </span>
                    <span class="text-danger fst-italic">(*)</span><br>
                    <form:select path="startDay" items="${day}" cssClass="col-4"><form:options items="${day}"/></form:select>
                    <form:select path="startMonth" items="${month}" cssClass="col-4"><form:options items="${month}"/></form:select>
                    <form:select path="startYear" items="${year}" cssClass="col-4"><form:options items="${year}"/></form:select>
                </div>
                <div class="col-6">
                    <span>Ngày kết thúc </span>
                    <span class="text-danger fst-italic">(*)</span><br>
                    <form:select path="endDay" items="${day}" cssClass="col-4"><form:options items="${day}"/></form:select>
                    <form:select path="endMonth" items="${month}" cssClass="col-4"><form:options items="${month}"/></form:select>
                    <form:select path="endYear" items="${year}" cssClass="col-4"><form:options items="${year}"/></form:select>
                </div>
            </div>
            <br>
            <p class="text-danger">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch,
                thuộc quản lý của Ban chỉ đạo quốc gia về Phòng chống dịch Covid-19. Khi bạn nhấn nút "Gửi" là bạn đã hiểu và
                đồng ý.</p><br>
            <button class="btn btn-success" style="margin-left: 45%" type="submit">Gửi tờ khai</button>
        </form:form>
    </div>
    <div class="col-2"></div>
</div>
</body>
</html>
