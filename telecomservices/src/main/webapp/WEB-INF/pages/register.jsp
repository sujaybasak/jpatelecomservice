<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<body>
<form method="get" action="/processregister">

<div>
<span>Name </span>
<input name="name" type="text" />
</div>

<div>
<span>Password </span>
<input name="password" type="password" />
</div>

<div>
<span>Mobile No </span>
<input name="mobileno" type="text" />
</div>

<div>
<span>Account Type </span><br>
<input type="radio" name="accounttype" value="prepaid"> Prepaid<br>
<input type="radio" name="accounttype" value="postpaid"> PostPaid<br>
</div>

<div>
<span>Balance </span>
<input name="recharge" type="number" />
</div>

<input type="submit" value="register"/>
</form>
</body>
</html>