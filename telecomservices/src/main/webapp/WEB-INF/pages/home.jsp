<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body>
<h2>
Mobile no is  <c:out value="${user.getMobileNo()}"/>
Name is <c:out value="${user.getName()}"/>
Account Type is<c:out value="${user.getAccountType()}"/>
Recharge amount<c:out value="${user.getBalance()}"/>
</h2>

<a href="/signout">Sign out</a>

</body>
</html>