<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Geo</title>
    <link href="<c:url value="/resources/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<h2>Geological Sections</h2>
<table>
    <tr>
        <th>id</th>
        <th>Section Name</th>
        <th>Class 1 Name</th>
        <th>Class 1 Code</th>
        <th>Class 2 Name</th>
        <th>Class 2 Code</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="geo" items="${geoList}">
        <tr>
            <td>${geo.id}</td>
            <td>${geo.name}</td>
            <td>geo class 1</td>
            <td>gc1</td>
            <td>geo class 2</td>
            <td>gc2</td>
            <td>
                <a href="/edit/${geo.id}">Edit</a><br>
                <a href="/delete/${geo.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new geological section</a>
</body>
</html>