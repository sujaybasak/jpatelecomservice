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

.p{
padding-left: 20%;
padding-right: 20%;
 padding-top: 5%;
 padding-bottom: 5%;
 background-color: #f0f8ff;
}
</style>

</head>

<body>
<div class="p">
<div class="container">

<h2 align ="center">Welcome <c:out value="${user.name}"/> Your details are given below. </h2>
<h3>
ID is  <c:out value="${user.id}"/><br>
Mobile no is  <c:out value="${user.mobileNo}"/><br>
Name is <c:out value="${user.name}"/><br>
Account Type is <c:out value="${user.accountType}"/><br>
Recharge amount <c:out value="${user.balance}"/><br>

 <form method="get" action="recharge">
    <label >Recharge:</label><br>
    <input name="amount" placeholder="Enter Recharge Amount" type="number" required>
    <button type="submit" class="registerbtn">Recharge</button>
    </form>
</h3>

<a href="/signout" class="registerbtn">Sign out</a>
</div>
</div>
</body>

</html>