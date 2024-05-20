<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootpath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
<style>
        /* CSS cho banner */
        .banner {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        /* CSS cho menu điều hướng */
        .menu {
            background-color: #f4f4f4;
            padding: 10px;
            text-align: center;
        }

        /* CSS cho bảng */
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        /* CSS cho các liên kết */
        a {
            color: #4CAF50;
            text-decoration: none;
        }

        a:hover {
            color: #333;
        }
		/* CSS cho phân trang */
        .pagination {
            margin-top: 20px;
            text-align: center;
        }

        .pagination a {
            color: #4CAF50;
            padding: 8px 16px;
            text-decoration: none;
            border: 1px solid #ddd;
        }

        .pagination a.active {
            background-color: #4CAF50;
            color: white;
        }

        .pagination a:hover:not(.active) {background-color: #ddd;}

        /* CSS cho nút thêm mới */
        .add-new-button {
            display: block;
            width: 100px;
            margin: 20px auto;
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>
	<%-- 	<fmt:setLocale value="vi_VN" /> --%>
	<fmt:setLocale value="en_US" />
	<jsp:include page="menu.jsp"></jsp:include>
	<hr>
	<div class="banner">
        <h1>Hệ thống Quản lý Nhân viên</h1>
    </div>
    <div class="menu">
        <a href="#">Trang chủ</a> | 
        <a href="#">Nhân viên</a> | 
        <a href="#">Bộ phận</a> | 
        <a href="#">Chức vụ</a>
    </div>
    <div class="content">
        <h2>Danh sách Nhân viên</h2>
        <table>
            <thead>
                <tr>
                    <th>Mã Nhân viên</th>
                    <th>Họ</th>
                    <th>Tên</th>
                    <th>Ngày sinh</th>
                    <th>Ngày vào làm</th>
                    <th>Phòng ban</th>
                    <th>Vị trí</th>
                    <th>Mức lương</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${lstEp}" var="e">
            <tr>
                    <td>${e.employee_id}</td>
                    <td>${e.first_name}</td>
                    <td>${e.last_name}</td>
                    <td>${e.date_of_birth}</td>
                    <td>${e.hire_date}</td>
                    <td>${e.department_name}</td>
                    <td>${e.position_name}</td>
                    <td>${e.salary_amount} VNĐ</td>
                    <td>
                        <a href="#">Cập nhật</a> | 
                        <a href="#">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
                
            </tbody>
        </table>
		 <div class="pagination">
            <a href="#">&laquo;</a>
            <a href="#">1</a>
            <a href="#" class="active">2</a>
            <a href="#">3</a>
            <a href="#">&raquo;</a>
        </div>
        <a href="#" class="add-new-button">Thêm mới</a>
    </div>
</body>
</html>