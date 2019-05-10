<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.endava.bookmanager3.util.MappingNames" %>
<html>
<head>
    <title>View Author</title>
</head>

<body>
<div align="center">
    <table>
        <tr>
            <td><label>ID</label></td>
            <td>
                <c:out value="${author.id}"/>
            </td>
        </tr>
        <tr>
            <td><label>Title</label></td>
            <td>
                <c:out value="${author.name}"/>
            </td>
        </tr>
        <tr>
            <td><label>Deadline</label></td>
            <td>
                <c:out value="${author.email}"/>
            </td>
        </tr>
        <tr>
            <td><label>Details</label></td>
            <td>
                <c:out value="${author.description}"/>
            </td>
        </tr>
    </table>

    <c:url var="tableUrl" value="${MappingNames.AUTHORS}"/>
    <a href="${tableUrl}">Show Table</a>

</div>
</body>
</html>

