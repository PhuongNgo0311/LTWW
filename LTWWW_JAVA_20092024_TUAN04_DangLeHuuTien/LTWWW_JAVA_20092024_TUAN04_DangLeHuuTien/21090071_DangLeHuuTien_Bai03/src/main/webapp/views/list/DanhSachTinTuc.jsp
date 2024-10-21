<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News Layout</title>
<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	width: 100%;
	max-width: 800px;
	margin: 0 auto;
	border: 1px solid black;
}

.header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	border-bottom: 1px solid black;
}

img {
	width: 100%;
}

.menu {
	text-align: center;
	padding: 10px;
	border-bottom: 1px solid black;
	background-color: #f2f2f2;
}

.menu a {
	margin: 0 15px;
	text-decoration: none;
	color: black;
	font-weight: bold;
}

.content {
	height: 400px;
	padding: 20px;
	border-bottom: 1px solid black;
}

.footer {
	text-align: center;
	padding: 10px;
	font-weight: bold;
}

.cart-table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

.cart-table th, .cart-table td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: center;
}

.cart-table th {
	background-color: #f4f4f4;
}

.cart-table img {
	width: 50px;
	height: auto;
}

</style>
</head>
<body>

	<div class="container">
		<!-- Header Section -->
		<div class="header">
			<img class="img" src="${pageContext.request.contextPath}/header.png" />
		</div>

		<!-- Menu Section -->
		<div class="menu">
		<a href="${pageContext.request.contextPath}/news">Thêm tin tức mới</a> 
		| <a href="${pageContext.request.contextPath}/managelist">Chức năng quản lý</a>
		</div>

		<!-- Content Section -->
		<div class="content">
			<table class="cart-table">
				<tr>
					<th>Tiêu đề</th>
					<th>Nội dung</th>
					<th>Liên kết</th>
					<th>Mã danh muc</th>
				</tr>

				<c:forEach var="item" items="${news}">
					<tr>
						<td>${item.tieuDe}</td>
						<td>${item.noiDungTT}</td>
						<td>${item.lienKet}</td>
						<td>${item.maDM}</td>
				</c:forEach>

			</table>
		</div>

		<!-- Footer Section -->
		<div class="footer">Dang Le Huu Tien – 21090071 – DHKTPM17BTT</div>
	</div>

</body>
</html>