<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title> Sandwich Condiments</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form  action="save" method="post">
  <label> Lettuce</label>
  <input type="checkbox" name="condiment" value="Lettuce">
  <br>
  <label> Tomato</label>
  <input type="checkbox" name="condiment" value="Tomato">
  <br>
  <label> Mustard</label>
  <input type="checkbox" name="condiment" value="Mustard">
  <br>
  <label>Sprouts</label>
  <input type="checkbox" name="condiment" value="Sprouts">
  <br>
  <input type="submit" value="Save">
</form>
</body>
</html>