<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP - Servlet</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<h1>Chào mừng tới thế giới Java Web</h1>
	Nhấn Ctrl + Shift + F: định dạng (format) mã code
	<br>
	<%
	out.println("Chào mừng tới ĐH Bách Khoa Hà Nội");
	out.println("<hr>Chào mừng tân sinh viên K69 - sinh năm 2006");

	int a, b;
	a = 5;
	b = 3;
	out.println("<br>Tổng: " + a + " + " + b + " = " + (a + b));
	%>
	<hr>
	<%
	Calendar calendar = Calendar.getInstance();
	Date date = calendar.getTime();

	// Locale locale = Locale.US;
	Locale locale = new Locale("vi", "VN");
	DateFormat fmt = DateFormat.getDateInstance(DateFormat.FULL, locale);
	String strDate = fmt.format(date);

	out.println("<br>Ngày hiện tại là: " + strDate);
	%>
	<br>
</body>
</html>