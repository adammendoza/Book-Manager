<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.endava.bookmanager3.util.MappingNames" %>
<html>
<head>
    <title>View Book</title>
</head>

<body>
<div align="center">
    <table>
        <tr>
            <td><label>ID</label></td>
            <td>
                <c:out value="${book.id}"/>
            </td>
        </tr>
        <tr>
            <td><label>Name</label></td>
            <td>
                <c:out value="${book.name}"/>
            </td>
        </tr>
        <tr>
            <td><label>Description</label></td>
            <td>
                <c:out value="${book.description}"/>
            </td>
        </tr>
    </table>

    <c:url var="tableUrl" value="${MappingNames.BOOKS}"/>
    <a href="${tableUrl}">Show Table</a>

</div>
</body>
</html>

