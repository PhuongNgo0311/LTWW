<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<style>

.container {
	width: 80%;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.product-grid {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
	justify-content: center;
}

.product {
	border: 1px solid #ccc;
	padding: 10px;
	width: 200px;
	text-align: center;
	background-color: #f9f9f9;
}

.product img {
	max-width: 100%;
	height: auto;
}

.product button {
	padding: 10px 15px;
	background-color: #28a745;
	color: #fff;
	border: none;
	cursor: pointer;
	border-radius: 5px;
}

.product button:hover {
	background-color: #218838;
}

.view-cart {
	text-align: left;
	margin-bottom: 20px;
}

.view-cart a {
	text-decoration: none;
	color: #007bff;
	font-size: 18px;
}
</style>
<script>
	function addToCart(productId) {
	    var quantityInput = document.getElementById("quantity_" + productId);
	    var quantity = quantityInput.value;
	    var url = "${pageContext.request.contextPath}/cart?action=buy&id=" + productId + "&number=" + quantity;
	    window.location.href = url;
	}
	</script>
</head>
<body>
	<div class="container">
		<div class="view-cart">

			<a href="${pageContext.request.contextPath}/cart">View Cart</a>
		</div>
		<div class="product-grid">
			<c:forEach var="product" items="${products}">
				<div class="product">
					<h3>${product.name}</h3>
					<img
						src="${pageContext.request.contextPath}/resources/images/${product.image}"
						alt="${product.name}">
					<p>Price: ${product.price}</p>
					<input type="number" id="quantity_${product.id}" value="1" min="1">
					<button onclick="addToCart(${product.id})">Add To Cart</button>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>