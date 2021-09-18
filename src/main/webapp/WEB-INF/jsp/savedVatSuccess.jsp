<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: powiej
  Date: 14.09.2021
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VAT tax saved</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Informacje na temat VATu zostały zapisane</h1>

<table>
    <tr>
        <td><a href="<c:url value="/userDetails"/>">Wróć do podsumowania</a></td>
    </tr>
    <tr>
        <td><a href="<c:url value="/formIncome"/>">Wypełnij nowy formularz odnośnie podatku dochodowego</a></td>
    </tr>
    <tr>
        <td><a href="<c:url value="/logout"/>">Wyloguj</a></td>
    </tr>
</table>

</body>
</html>
