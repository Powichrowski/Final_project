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
    <title>Income tax</title>
</head>
<body>
<form action="/user/income" method="post">
    <h2>Wybierz formę zatrudnienia</h2><br>
    <label>Umowa o pracę  <input type="radio" name="type" value="contract"></label><br>
    <label>Umowa o dzieło <input type="radio" name="type" value="product"></label><br>
    <label>B2B            <input type="radio" name="type" value="b2b"></label><br>
    <label>Miesięczne zarobki brutto<input type="number" name="salary"></label><br>

    <input type="submit" value="Wyślij">

</form>
</body>
</html>
