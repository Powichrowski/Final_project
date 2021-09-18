<%--
  Created by IntelliJ IDEA.
  User: powiej
  Date: 15.09.2021
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vat tax</title>
</head>
<body>
<form action="/user/vat" method="post">
    <h3>Podaj miesięczne wydatki w poszczególnych kategoriach</h3><br>
    <label>Jedzenie i napoje<input type="number" name="grocery"></label><br>
    <label>Rachunki za media<input type="number" name="bills"></label><br>
    <label>Rozrywka (np: bilety do kina)<input type="number" name="entertainment"></label><br>
    <label>Usługi (np: fryzjer) <input type="number" name="services"></label><br>
    <label>Alkohol<input type="number" name="alcohol"></label><br>
    <label>Papierosy<input type="number" name="cigarettes"></label><br>

<input type="submit" value="Wyślij">

</form>
</body>
</html>
