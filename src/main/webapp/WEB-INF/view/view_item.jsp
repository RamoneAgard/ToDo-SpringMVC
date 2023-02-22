<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="agard.spring.util.Mappings" %>
<html>
<head>
    <title>Task View</title>
</head>
<body>

    <div align="center">

        <table border="1" cellpadding="5">

            <caption><h2> Task </h2></caption>
            <tr>
                <th>ID</th>
                <td>${todoItem.id}</td>
            </tr>
            <tr>
                <th>Title</th>
                <td>${todoItem.title}</td>
            </tr>
            <tr>
                <th>Deadline</th>
                <td><c:out value="${todoItem.deadline}"/></td>
            </tr>
            <tr>
                <th>Details</th>
                <td><c:out value="${todoItem.details}"/></td>
            </tr>

        </table>

        <c:url var="listUrl" value="${Mappings.ITEMS}" />
        <a href="${listUrl}"> Back to ToDo List </a>

    </div>
</body>
</html>