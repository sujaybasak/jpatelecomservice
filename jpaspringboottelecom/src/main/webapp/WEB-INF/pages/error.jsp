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
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}
</style>

</head>
<body>
<div class="container">
<h1>Error Page </h1>
<h3>

<c:out value="${message}"/>
</h3>
<a href="/register" class="registerbtn">Go to Registration Page</a>
</div>
</body>
</html>