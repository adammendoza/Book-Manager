<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.endava.bookmanager3.util.MappingNames" %>
<html>
<head>
    <title>Authors</title>
</head>

<body>
<div align="center">

    <c:url var="addUrl" value="${MappingNames.ADD_AUTHOR}"/>

    <a href="${addUrl}">New Author</a>

    <table border="1" cellpadding="5">
        <caption><h2>Authors</h2></caption>

        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="author" items="${authors}">

            <c:url var="viewUrl" value="${MappingNames.VIEW_AUTHOR}">
                <c:param name="id" value="${author.id}"/>
            </c:url>

            <c:url var="editUrl" value="${MappingNames.ADD_AUTHOR}">
                <c:param name="id" value="${author.id}"/>
            </c:url>

            <c:url var="deleteUrl" value="${MappingNames.DELETE_AUTHOR}">
                <c:param name="id" value="${author.id}"/>
            </c:url>

            <tr>
                <td>${author.name}</td>
                <td>${author.email}</td>
                <td>${author.description}</td>
                <td><a href="${viewUrl}">View</a></td>
                <td><a href="${editUrl}">Edit</a></td>
                <td><a href="${deleteUrl}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
