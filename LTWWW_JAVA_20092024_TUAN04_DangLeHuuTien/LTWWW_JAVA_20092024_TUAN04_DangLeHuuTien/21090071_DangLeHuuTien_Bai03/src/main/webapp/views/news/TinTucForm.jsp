<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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

form {
    background-color: #fff; 
    max-width: 500px; 
    margin: auto;
}

label {
    display: block;
}

input[type="text"],
input[type="number"],
input[type="url"],
textarea {
    width: 100%; 
    padding: 10px;
    margin-bottom: 15px; 
    border: 1px solid #ccc; 
    border-radius: 4px;
    font-size: 16px;
}

textarea {
    resize: vertical; 
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
			<a href="${pageContext.request.contextPath}/list">Danh sách tin tức</a> |
			 <a href="${pageContext.request.contextPath}/managelist">Chức năng quản lý</a>
		</div>

		<form action="TinTucFormServlet" method="post">
			<br> <label for="tieuDe">Tiêu Đề:</label> 
			<input type="text" id="tieuDe" name="tieuDe" required><br>
			<br> <label for="noiDungTT">Nội Dung Tin Tức:</label>
			<textarea id="noiDungTT" name="noiDungTT" rows="4" cols="50" required></textarea>
			<br>
			<br> <label for="lienKet">Liên Kết:</label> 
			<input type="url" id="lienKet" name="lienKet" required><br>
			<br> <label for="maDM">Mã Danh Mục:</label> 
			<input type="text" id="maDM" name="maDM" required><br>
			<br>
  			<input type="submit" value="Submit">
		</form>



		<!-- Footer Section -->
		<div class="footer">Dang Le Huu Tien – 21090071 – DHKTPM17BTT</div>
	</div>

</body>
</html>