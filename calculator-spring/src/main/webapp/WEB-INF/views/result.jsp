<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h4>Condiments </h4>
    <c:forEach items="${condiments}" var="condiment">
        <c:out value="${condiment}"></c:out>
        <br>
    </c:forEach>
</body>
</html>
