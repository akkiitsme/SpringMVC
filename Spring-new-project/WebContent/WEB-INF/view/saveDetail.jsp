<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details is Saved</title>
<link rel="stylesheet" href="https://betaob.pasmt.com/css/bootstrap.css">
<style type="text/css">
h3 {
	text-align: center;
	color: greeen;
}
.heading-color{
	color: red;
}
</style>
</head>

<body class="container">
	<br>

	<h3>
		<span class="heading-color">Congratulations !!</span> Your data has been saved
	</h3>
	<hr>
	<table class="table table-bordered text-center table-hover">
		<tr>
			<th>Name</th>
			<th>Gender</th>
			<th>Date of Birth</th>
			<th>EmpStatus</th>
			<th>OrgName</th>
			<th>Education</th>
		</tr>
		<tr>
			<td>${employee.firstName}${employee.lastName}</td>
			<td>${employee.gender}</td>
			<td>${employee.year}-${employee.month}-${employee.day}</td>
			<td>${employee.empStatus}</td>
			<td>${employee.orgName }</td>
			<td>${employee.edu}</td>
		</tr>
	</table>
	<hr>
</body>
</html>