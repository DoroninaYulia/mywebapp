<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit mail</title>
</head>
<body>
<form method="post" action="/mywebapp/mails/save">
    <jsp:useBean id="mail" scope="request" class="org.itstep.myWebApp.model.Mail"/>
    <input type="hidden" name="id" value="${user.id}">

    <dl>Name:</dl>
    <dt><input type="text" name="name" value="${mail.name}"></dt>

    <dl>Text:</dl>
    <dt><input type="text" name="text" value="${mail.text}"></dt>

    <dl>To:</dl>
    <dt><input type="text" name="to" value="${mail.to}"></dt>

    <dl>Created:</dl>
    <dt><input type="text" name="created" value="${mail.created}"></dt>

    <button type="submit">SAVE</button>
</form>

</body>
</html>
