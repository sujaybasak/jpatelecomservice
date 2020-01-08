<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: white;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 50px;
  background-color:rgb(198, 228, 230);
}

/* Full-width input fields */
input[type=text], input[type=password],input[type=number] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: white;
}

input[type=text]:focus, input[type=password]:focus,input[type=number]:focus  {
  background-color: #ccc;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #0000ff;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}
.alert {
  padding: 20px;
  background-color: #f44336;
  color: white;
}

.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

.closebtn:hover {
  color: black;
}
.pad{
padding-left: 20%;
padding-right: 20%;
 padding-top: 5%;
 padding-bottom: 5%;
 background-color: #f0f8ff;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>
<div class="pad">
<body>

<form method="GET" action="processregister">
  <div class="container">
    <h1 align="center">Registration From</h1>
    <p align= "center">Please fill in this form to create an telecom account.</p>
    <br>

    <label for="name">Name </label> <br>
    <input name="name" placeholder="Enter your name" type="text" />
    <br>
    <label for="mobileno">Mobile No </label> <br>
    <input name="mobileno" placeholder="Enter your mobile number" type="text" required/>
     <c:if test="${message!=null}">
    	<div class="alert">
  		<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  		<strong><c:out value="${message}"/></strong>
		</div>     
        
    </c:if>
    <br>
    <label for="password">Password </label> <br>
    <input name="password" placeholder="Choose your password" type="password" required/>
    <br>
    <label for="accounttype">Account Type </label><br> 
    <input type="radio" name="accounttype" value="prepaid"> Prepaid<br>
    <input type="radio" name="accounttype" value="postpaid"> PostPaid<br>


		
    <label for="recharge">Balance Amount </label> <br>
    <input name="recharge"  placeholder="Enter starting recharge amount" type="number" />
    <br>

    <button type="submit" class="registerbtn">Register</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="/userinput">Sign in</a>.</p>
  </div>
</form>


</body>
</div>
</html>
