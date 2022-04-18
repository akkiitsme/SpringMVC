<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://betaob.pasmt.com/css/bootstrap.css">
    
<title>Confirmation Page</title>
<style>
h2{text-align: center;}


</style>
</head>
<body class="container">
<br>
<h2><span style="color:red">Congartulations...!</span> Your data has been saved</h2><br><br>
<hr>
<table class="table table-bordered table-hover text-center">
 <tr>
 <th>Name</th>
 <th>Gender</th>
 <th>DOB</th>
 <th>Employee Status</th>
 <th>Organization Name</th>
 <th>Education</th>
 </tr>
 <tr>
 <td class="text-success">${employeeDetails.firstName} ${employeeDetails.lastName}</td>
 <td  class="text-success">${employeeDetails.gender}</td>
 <td  class="text-success">${employeeDetails.year}-${employeeDetails.month}-${employeeDetails.day}</td>
 <td  class="text-success">${employeeDetails.empStatus}</td>
 <td class="text-success">${employeeDetails.orgName}</td>
 <td  class="text-success">${employeeDetails.edu}</td>
 </tr>
 
</table>


</body>
</html>