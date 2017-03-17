<%@ page import="org.itstep.myWebApp.model.Mail" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Mail list</title>
</head>
<body>
<form method="get" action="mails/search">
    <input type="text" name="userId">
    <button type="submit">Search</button>
</form>

<table cellspacing="0" cellpadding="5" border="1">
    <thead>
    <tr>
        <td>Name</td>
        <td>Text</td>
        <td>To</td>
        <td>Created</td>
        <td colspan="2">Action</td>
    </tr>
    </thead>

    <c:forEach items="${mailList}" var="mail">
        <tr>
            <jsp:useBean id="mail" class="org.itstep.myWebApp.model.Mail"/>
            <td>${mail.name}</td>
            <td>${mail.text}</td>
            <td>${mail.to}</td>
            <td>${mail.created}</td>
            <td><a href="mails/update?id=${mail.id}">UPDATE</a> </td>
            <td><a href="mails/delete?id=${mail.id}">DELETE</a></td>
        </tr>
    </c:forEach>
</table>
<a href="mails/create">Create new one</a><br/>
<a href="mails/deleteAll">Delete all entity by user id</a>
</body>
</html>
