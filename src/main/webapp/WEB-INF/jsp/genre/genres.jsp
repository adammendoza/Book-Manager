<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.endava.bookmanager3.util.MappingNames" %>
<html>
<head>
    <title>Genres</title>
</head>

<body>
<div align="center">

    <c:url var="addUrl" value="${MappingNames.ADD_GENRE}"/>

    <a href="${addUrl}">New Genre</a>

    <table border="1" cellpadding="5">
        <caption><h2>Genres</h2></caption>

        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="author" items="${genres}">

            <c:url var="viewUrl" value="${MappingNames.VIEW_GENRE}">
                <c:param name="id" value="${genre.id}"/>
            </c:url>

            <c:url var="editUrl" value="${MappingNames.ADD_GENRE}">
                <c:param name="id" value="${genre.id}"/>
            </c:url>

            <c:url var="deleteUrl" value="${MappingNames.DELETE_GENRE}">
                <c:param name="id" value="${genre.id}"/>
            </c:url>

            <tr>
                <td>${genre.name}</td>
                <td>${genre.description}</td>
                <td><a href="${viewUrl}">View</a></td>
                <td><a href="${editUrl}">Edit</a></td>
                <td><a href="${deleteUrl}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
