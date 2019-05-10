<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.endava.bookmanager3.util.MappingNames" %>
<html>
<head>
    <title>Awards</title>
</head>

<body>
<div align="center">

    <c:url var="addUrl" value="${MappingNames.ADD_AWARD}"/>

    <a href="${addUrl}">New Award</a>

    <table border="1" cellpadding="5">
        <caption><h2>Awards</h2></caption>

        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="award" items="${awards}">

            <c:url var="viewUrl" value="${MappingNames.VIEW_AWARD}">
                <c:param name="id" value="${award.id}"/>
            </c:url>

            <c:url var="editUrl" value="${MappingNames.ADD_AWARD}">
                <c:param name="id" value="${award.id}"/>
            </c:url>

            <c:url var="deleteUrl" value="${MappingNames.DELETE_AWARD}">
                <c:param name="id" value="${award.id}"/>
            </c:url>

            <tr>
                <td>${award.name}</td>
                <td>${award.description}</td>
                <td><a href="${viewUrl}">View</a></td>
                <td><a href="${editUrl}">Edit</a></td>
                <td><a href="${deleteUrl}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
