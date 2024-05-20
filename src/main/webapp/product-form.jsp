<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="rootpath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form sản phẩm</title>
<style>
body {
	font-family: Arial, sans-serif;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	border: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

label {
	display: block;
	margin-bottom: 5px;
}

input, select {
	width: 100%;
	padding: 5px;
	margin-bottom: 10px;
}

input[type="submit"] {
	background-color: #007bff;
	color: #fff;
	border: none;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<c:if test="${isOk!=null}">
		<c:choose>
			<c:when test="${isOk}">
				<span style="color: blue">Thêm mới thành công</span>
			</c:when>
			<c:when test="${isOk == false}">
				<span style="color: red">Thêm THẤT BẠI</span>
			</c:when>
		</c:choose>
	</c:if>
	
	<c:if test="${isUpdateOk!=null}">
		<c:choose>
			<c:when test="${isUpdateOk}">
				<span style="color: blue">Cập nhật thành công</span>
			</c:when>
			<c:when test="${isUpdateOk == false}">
				<span style="color: red">Cập nhật THẤT BẠI</span>
			</c:when>
		</c:choose>
	</c:if>

	<h1>Thêm mới sản phẩm</h1>
	<form
		action="${rootpath}${prd==null? 'product-insert':'product-update'}"
		method="POST">
		<table>
			<tr>
				<th><label for="product_id">Mã sản phẩm:</label></th>
				<td><input type="text" id="product_id" name="product_id"
					value="${prd.product_id}" readonly="readonly"></td>
			</tr>
			<tr>
				<th><label for="product_name">Tên sản phẩm:</label></th>
				<td><input type="text" id="product_name" name="product_name"
					value="${prd.product_name}"></td>
			</tr>
			<tr>
				<th><label for="price">Giá:</label></th>
				<td><input type="number" id="price" name="price" step="500"
					value="${prd.price}"></td>
			</tr>
			<tr>
				<th><label for="stock_quantity">Số lượng tồn kho:</label></th>
				<td><input type="number" id="stock_quantity"
					name="stock_quantity" required value="${prd.stock_quantity}"></td>
			</tr>
			<tr>
				<th><label for="category_id">Danh mục:</label></th>
				<td><select id="category_id" name="category_id">
						<c:forEach items="${lstcat}" var="c">
							<option value="${c.category_id}"
								${c.category_id==prd.category_id? 'selected="selected"' : ''}>${c.category_name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th><label for="image">Hình ảnh:</label></th>
				<td><c:if test="${prd!=null}">
						<img width="200px" alt="${prd.product_name}" src="${prd.image}">
					</c:if> <input type="text" id="image" name="image" value="${prd.image}"></td>
			</tr>
		</table>
		<input type="submit" value="Lưu lại">
	</form>
</body>
</html>