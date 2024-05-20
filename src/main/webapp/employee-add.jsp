<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootpath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Thêm Nhân viên mới</title>
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

        /* CSS cho form */
        form {
            width: 50%;
            margin: 0 auto;
        }

        input[type=text], input[type=date], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
	<%-- 	<fmt:setLocale value="vi_VN" /> --%>
	<fmt:setLocale value="en_US" />
	<jsp:include page="menu.jsp"></jsp:include>
	<hr>
	<div class="banner">
        <h1>Thêm Nhân viên mới</h1>
    </div>
    <div class="menu">
        <a href="#">Trang chủ</a> | 
        <a href="#">Nhân viên</a> | 
        <a href="#">Bộ phận</a> | 
        <a href="#">Chức vụ</a>
    </div>
   <div class="content">
        <form action="/" method="POST">
            <label for="first_name">Họ:</label>
            <input type="text" id="first_name" name="first_name" required><br>

            <label for="last_name">Tên:</label>
            <input type="text" id="last_name" name="last_name" required><br>

            <label for="date_of_birth">Ngày sinh:</label>
            <input type="date" id="date_of_birth" name="date_of_birth" required><br>

            <label for="hire_date">Ngày vào làm:</label>
            <input type="date" id="hire_date" name="hire_date" required><br>

            <label for="department">Phòng ban:</label>
           <select id="department" name="department">
				<c:forEach items="${lstD}" var="d">
            		<option value="${d.department_id}">${d.department_name}</option>
            	</c:forEach>
            </select><br> 

            <label for="position">Vị trí:</label>
            <select id="position" name="position">
                <c:forEach items="${lstP}" var="p">
            		<option value="${p.position_id}">${p.position_name}</option>
            	</c:forEach>
            </select><br>

            <label for="salary">Mức lương:</label>
            <input type="text" id="salary" name="salary" required><br>

            <input type="submit" value="Thêm Nhân viên">
        </form>
    </div>
</body>
</html>