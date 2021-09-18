<%--
  Created by IntelliJ IDEA.
  User: powiej
  Date: 16.09.2021
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>Zaloguj się</h3>
<form method="post" action="/loginSuccess">
<label>Login<input type="text" name="login"></label>
<%--<label>Email    <input type="email" name="email"></label><br>--%>
<label>Password <input type="password" name="password"></label><br>
<br>
<input type="submit" value="Zaloguj się">
</form>

<h2>${message}</h2>
</body>
</html>
