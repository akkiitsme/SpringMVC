<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--<link href="fonts/fontawesome/web-fonts-with-css/css/fontawesome.css" rel="stylesheet">-->
    <!-- Bootstrap CSS -->

    <link rel="stylesheet" href="https://betaob.pasmt.com/css/bootstrap.css">
    <link rel="stylesheet" href="https://betaob.pasmt.com/css/style.css">
    
    
<title>Employee Details</title>
</head>
<body class="nothomepage">
<div class="home_header">
<header id="main_header">
    <div class="container_lzt">
      <div class="row">
        <div class="col-sm-5 col-md-4"> <a href="index.html"><img src="https://betaob.pasmt.com/images/logo.png" class="logo_full" width="180" alt=""></a> </div>
      
      </div>
    </div>
  </header>
</div>  

<div class="content_area shaded mb-minus-5">
	<div class="container_lzt">
			<section id="welcome_loginpage" class="my_account">
            
            <div class="row">
                <div class="col-sm-4 col-md-4 mobile-bgwhite wlc_block mh-100">
                            <article class="pr-5">
                            	<h2 class="ft-60 dark_blue  wow fadeInLeft" data-wow-duration="1.2s" data-wow-delay="0.8s">Welcome</h2>
                                <p class="ft-16  wow fadeInLeft" data-wow-duration="1.2s" data-wow-delay="0.8s"></p>
                            
                            <img src="https://betaob.pasmt.com/images/my_account.png" class="img-fluid pr-5  wow fadeInLeft  d-none d-sm-block" data-wow-duration="1.2s" data-wow-delay="0.8s" alt="">
                            </article>
                            
                </div>	
                <div class="col-sm-8 col-md-8">
                	
                        
                 
                        
                        <div class="row">
                        		<div class="col-md-12">
                                		<div class="about_panelist bg-white border p-3 mt-5 pt-5 position-relative">
                                        		
                                                <div class="form-input">
                                                
                                                <form:form action="updateForm" modelAttribute="employeeDetails">
                                                
                                                		<table class="table border-0 ft-14 bg-white">
                                                    	<tr>
                                                        	<td width="50%">Panelist ID</td>
                                                            <td> ${employeeDetails.userInfoId}</td>
                                                            <td><form:hidden  path="userInfoId" /></td> 
                                                        </tr>
                                                        <tr>
                                                        	<td>Name</td>
															<td><form:input path="firstName" type="text" class="half"
																placeholder="first name" /> 
																<form:input path="lastName" type="text"
																 class="half" placeholder="Last name" />
															</td>
                                                        </tr>
                                                        <tr>
                                                        	<td>Gender</td>
                                                        	<td><label class="form-check-label"> <form:radiobutton path="gender"
																class="form-check-input dark_checkbox"
																 value="M" /> <span class="custom_check"></span>
																Male
														</label> <label class="form-check-label"> <form:radiobutton path="gender"
																 class="form-check-input dark_checkbox"
																 value="F"/> <span class="custom_check"></span>
																Female
														</label></td>
                                                                  
                                                        </tr>
                                                        <tr>
                                                        	<td>Date Of Birth</td>
                                                        	<td><form:select path="day">
																<form:option value="" label="day"/>
																<c:forEach var="data" items="${day}" >
																<form:option value="${data.id}">${data.val}</form:option>
																</c:forEach>
														</form:select> 
														<form:select path="month">
																<form:option value="" label="month"/>
																<c:forEach var="data" items="${month}">
																<form:option value="${data.id}">${data.val}</form:option>
																</c:forEach>
														</form:select> 
														<form:select path="year">
																<form:option value="" label="year"/>
																<c:forEach var="data" items="${year}">
																<form:option value="${data.id}">${data.val}</form:option>
																</c:forEach>
														</form:select></td>
																
                                                        </tr>
                                                        
                                                        <tr>
                                                        	<td>Employee Status</td>
                                                        	<td><form:select path="empStatus">
																<form:option value="" label="-------------------------Please Select-----------------------"/>
																<c:forEach var="data" items="${empStatus}">
																	<form:option value="${data.id}">${data.val}</form:option>
																</c:forEach>
														</form:select></td>
                                                        </tr>
                                                        <tr>
                                                        	<td>Current Organization</td>
                                                        	<td><form:input type="text" path="orgName"
																placeholder="current organization" /></td>
                                                        </tr>
                                                        <tr>
                                                        	<td>Highest level of Education</td>
                                                        	<td><form:select path="edu">
																	<form:option value="" label="-------------------------Please Select-----------------------"/>
																	<c:forEach var="data" items="${edu}">
																		<form:option value="${data.id}">${data.val}</form:option>
																	</c:forEach>
															</form:select></td>
                                                        </tr>
                                               
                                                    </table>
                                                    <div class="text-center">
                                                    <button class="btn btn-info" >SAVE</button>
                                                    </div>
                                                    </form:form>
                                                </div>
                                                
                                                
                                        
                                        </div>
                                </div>						
						
                        
                        
                        
                                
                        </div>
                        
                       
                        
                        
                </div>
                
            </div>    
             	
             
                 
            </section>
    
    </div>
    
</div>

</body>
</html>