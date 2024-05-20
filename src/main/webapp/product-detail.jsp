<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/" var="rootpath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.product-details {
	display: flex;
	flex-direction: column;
	align-items: center;
}

.product-image {
	max-width: 300px;
}
</style>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<hr>
	<h2>Chi tiết sản phẩm</h2>
	<div class="product-details">
		<h2>${prd.product_name}</h2>
		<p>ID: ${prd.product_id}</p>
		<p>Giá: ${prd.price}</p>
		<p>Số lượng tồn kho: ${prd.stock_quantity}</p>
		<p>Loại sản phẩm: ${prd.category_id}</p>
		<img class="product-image" src="${prd.image}" alt="Hình ảnh sản phẩm">
	</div>

</body>
</html>