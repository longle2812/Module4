<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Converter</title>
  </head>
  <body>
  <form method="post">
    <h3>Converter</h3>
    <div>
      <h4>Input your rate</h4>
      <input type="number" name="rate" placeholder="Enter number" value="${rate}">
    </div>
    <div>
      <h4>Input money (USD)</h4>
      <input type="number" name="usd" placeholder="Enter number" value="${usd}">
    </div>
      <input type="submit" value="Convert" style="margin-top: 20px; margin-bottom: 20px">
    <div>
      <h4>Result:</h4>
      <input readonly type="number" name="vnd" value="${vnd}">
    </div>
  </form>
  </body>
</html>
