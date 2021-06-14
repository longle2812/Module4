<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title> Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form method="post">
  <input type="text" name="number1" value="${number1}">
  <input type="text" name="number2" value="${number2}">
  <br>
  <input type="submit" value="Addition(+)" name="+">
  <input type="submit" value="Subtraction(-)" name="-">
  <input type="submit" value="Multiplication(x)" name="x">
  <input type="submit" value="Division(/)" name="/">
</form>

<h2> ${message}</h2>
</body>
</html>