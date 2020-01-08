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
.registerbtn {
  background-color: #0000ff;
  color: white;
  text-align: center;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 20%;
  opacity: 0.9;
}
</style>

</head>
<body>

<div class="container">
<h2 align ="center">Welcome <c:out value="${user.getName()}"/> Your details are given below. </h2>
<h3>
ID is  <c:out value="${user.id}"/><br>
Mobile no is  <c:out value="${user.mobileNo}"/><br>
Name is <c:out value="${user.getName()}"/><br>
Account Type is <c:out value="${user.getAccountType()}"/><br>
Recharge amount <c:out value="${user.getBalance()}"/><br>
</h3>

<a href="/signout" class="registerbtn">Sign out</a>
</div>
</body>
</html>