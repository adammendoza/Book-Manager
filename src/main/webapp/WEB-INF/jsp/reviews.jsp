<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.endava.bookmanager3.util.MappingNames" %>
<html>
<head>
    <title>Reviews</title>
</head>

<body>
<div align="center">

    <c:url var="addUrl" value="${MappingNames.ADD_REVIEW}"/>

    <a href="${addUrl}">New Review</a>

    <table border="1" cellpadding="5">
        <caption><h2>Reviews</h2></caption>

        <tr>
            <th>Description</th>
            <th>Rating</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="review" items="${reviews}">

            <c:url var="viewUrl" value="${MappingNames.VIEW_REVIEW}">
                <c:param name="id" value="${review.id}"/>
            </c:url>

            <c:url var="editUrl" value="${MappingNames.ADD_REVIEW}">
                <c:param name="id" value="${review.id}"/>
            </c:url>

            <c:url var="deleteUrl" value="${MappingNames.DELETE_REVIEW}">
                <c:param name="id" value="${review.id}"/>
            </c:url>

            <tr>
                <td>${review.description}</td>
                <td>${review.rating}</td>
                <td><a href="${viewUrl}">View</a></td>
                <td><a href="${editUrl}">Edit</a></td>
                <td><a href="${deleteUrl}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
