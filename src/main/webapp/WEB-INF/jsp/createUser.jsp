<%--
  Created by IntelliJ IDEA.
  User: powiej
  Date: 14.09.2021
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<h3>Utwórz konto</h3><br>
<form action="/user/signing-check" method="post">

    <label>Login    <input type="text" name="login"></label><br>
    <label>Email    <input type="email" name="email"></label><br>
    <label>Password <input type="password" name="password"></label><br>

    <input type="submit" value="Utwórz konto">

</form>

<h1>${msg}</h1>

</body>
</html>