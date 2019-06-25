<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty geo.name}">
        <title>Add Geological Sections</title>
    </c:if>
    <c:if test="${!empty geo.name}">
        <title>Edit Geological Sections</title>
    </c:if>
</head>
<body>
<c:if test="${empty geo.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty geo.name}">
    <c:url value="/add" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty geo.name}">
        <input type="hidden" name="id" value="${geo.id}">
    </c:if>
    <label for="name">Section Name</label>
    <input type="text" name="name" id="name" value="${geo.name}">

    <c:if test="${empty geo.name}">
        <input type="submit" value="Add new geo section">
    </c:if>
    <c:if test="${!empty geo.name}">
        <input type="submit" value="Edit geo section">
    </c:if>
</form>
</body>
</html>