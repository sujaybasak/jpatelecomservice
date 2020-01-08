<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
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

input[type=text]:focus, input[type=password]:focus,input[type=number]:focus {
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
<body>
<div class="pad">
 <div class="container">
<h2 align ="center">Login Page</h2>

<form method="get" action="logincheck">
<div>
<span>Id </span><br>
<input name="mobileno" type="number" />
</div>
<div>
<span>Password</span><br>
<input name="password" type="password" />
 <c:if test="${message!=null}">
    	<div class="alert">
  		<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
  		<strong><c:out value="${message}"/></strong>
		</div>

    </c:if>
</div>
<div  align ="center">
<input type="submit" class="registerbtn" value="Submit"/>
</div>
 <div class="container signin">
    <p>New User? Create Account <a href="/register">Sign up</a>.</p>
  </div>
</form>
</div>
</div>
</body>
</html>