<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>English dictionary </title>
</head>
<body>
<form method="post">
    <div>
        <h3>English word</h3>
        <input type="text" name="eng" value="${eng}">
        <input type="submit" value="Search">
    </div>
    <div>
        <h3>Vietnamese word</h3>
        <input readonly type="text" name="vnm" value="${vnm}">
    </div>
</form>
</body>
</html>
