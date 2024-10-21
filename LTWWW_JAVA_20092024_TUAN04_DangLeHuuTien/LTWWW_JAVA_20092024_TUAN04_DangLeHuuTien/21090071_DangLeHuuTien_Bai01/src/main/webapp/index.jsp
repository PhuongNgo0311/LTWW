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
	display: flex;
	justify-content: center;
	align-items: center;
}

.registration-form {
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 300px;
}

.form-group {
	display: flex;
	flex-direction: column;
	margin-bottom: 15px;
}


.birthday-group {
	display: flex;
	justify-content: space-between;
}

.birthday-group select {
	width: 35%;
}

.gender-group {
	display: flex;
	justify-content: space-between;
}

</style>
</head>
<body>
	<div class="registration-form">
		<h2>User Registration Form</h2>
		<form action="UserController" name="formSignUp" method="post">
			<div class="form-group">
				<input type="text" placeholder="First Name" name="firstName"
					required><br>
				<input type="text" placeholder="Last Name"
					name="lastName" required>
			</div>
			<div class="form-group">
				<input type="email" placeholder="Your Email" name="email" required>
			</div>
			<div class="form-group">
				<input type="password" placeholder="New Password" name="password"
					required>
			</div>
			<div class="form-group">
				<label>Birthday</label>
				<div class="birthday-group">
					<select name="month">
						<option value="">Month</option>
						<option value="1">January</option>
						<option value="2">February</option>
						<option value="3">March</option>
						<option value="4">April</option>
						<option value="5">May</option>
						<option value="6">June</option>
						<option value="7">July</option>
						<option value="8">August</option>
						<option value="9">September</option>
						<option value="10">October</option>
						<option value="11">November</option>
						<option value="12">December</option>
					</select> 
					<select name="day">
						<option value="">Day</option>
						<%for (int i = 1; i <= 31; i++) {%>
						<option value="<%=i%>"><%=i%></option><%}%>

					</select> 
					<select name="year">
						<%int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);%>
						<%for (int i = currentYear; i >= 1900; i--) {%>
						<option value="<%=i%>"><%=i%></option><%}%>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label>Gender</label>
				<div class="gender-group">
					<input type="radio" name="gender" value="female"> Female <input
						type="radio" name="gender" value="male"> Male
				</div>
			</div>
			<input type="submit" value="Sign Up">
		</form>
	</div>
</body>
</html>