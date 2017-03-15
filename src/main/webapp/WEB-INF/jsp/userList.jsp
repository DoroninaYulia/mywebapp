<%@ page import="org.itstep.myWebApp.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
<table cellspacing="0" cellpadding="5" border="1">
    <thead>
    <tr>
        <td>Name</td>
        <td>Last name</td>
        <td>City</td>
        <td>Email</td>
        <td colspan="2">Action</td>
    </tr>
    </thead>

    <c:forEach items="${userList}" var="user">
        <tr>
            <jsp:useBean id="user" class="org.itstep.myWebApp.model.User"/>
            <td>${user.name}</td>
            <td>${user.lastname}</td>
            <td>${user.city}</td>
            <td>${user.email}</td>
            <td><a href="users/update?id=${user.id}">UPDATE</a> </td>
            <td><a href="users/delete?id=${user.id}">DELETE</a></td>
        </tr>
    </c:forEach>
</table>
<a href="users/create">Create new one</a>
</body>
</html>
