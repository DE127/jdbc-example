<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootpath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	Ctrl + Shift + C: Format code
	<%-- 	<fmt:setLocale value="vi_VN" /> --%>
	<fmt:setLocale value="en_US" />
	<jsp:include page="menu.jsp"></jsp:include>
	<hr>
	<b>${title}</b>
	<table>
		<thead>
			<tr>
				<th>Mã SP</th>
				<th>Tên sản phẩm</th>
				<th>Giá tiền</th>
				<th>Số lượng</th>
				<th>Mã danh mục</th>
				<th>Ảnh minh họa</th>
				<th>Cập nhật</th>
				<th>Xóa</th>
			</tr>
		</thead>
		<tbody>
			<!-- Sử dụng thẻ c:forEach để nhân bản dữ liệu của List gửi từ Servlet -->
			<c:forEach items="${lstprd}" var="p">
				<tr>
					<td>${p.product_id}</td>
					<td>
					<a href="${rootpath}product-detail?id=${p.product_id}">${p.product_name}</a>
					</td>
					<td><fmt:formatNumber value="${p.price}" type="currency" /></td>
					<td><fmt:formatNumber value="${p.stock_quantity}"
							type="number" /></td>
					<td>${p.category_id}</td>
					<td><img width="50" src="${p.image}" alt="${p.product_name}"></td>
					<td align="center"><a href="${rootpath}product-update?idupdate=${p.product_id}">
							<img alt="Cập nhật ${p.product_name}"
							src="${rootpath}images/update.png">
					</a></td>
					<td align="center"><a href="${rootpath}product-delete?iddelete=${p.product_id}">
							<img alt="Xóa ${p.product_name}"
							src="${rootpath}images/delete.png">
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>