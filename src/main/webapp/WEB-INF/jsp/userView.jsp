<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: powiej
  Date: 16.09.2021
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User view</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<h2>Poniżej znajdują się wszystkie dane na temat Twoich podatków:</h2>

<table>
    <tr><h2>Szczegóły podatku dochodowego</h2></tr>
    <tr>
        <td><h4>Podatek dochodowy wynosi średnio na miesiąc</h4></td>
        <td><h4>${Math.floor(salaryTax * 100) / 100} zł</h4></td>
    </tr>
</table>

<table>
    <tr><h2>Szczegóły podatku VAT</h2></tr>
    <tr>
        <td><h4>Podatki związane z alkoholem wynoszą średnio na miesiąc</h4></td>
        <td><h4>${Math.floor(vatAlcohol * 100) / 100} zł</h4></td>
    </tr>
    <tr>
        <td><h4>Podatki związane z rachunkami wynoszą średnio na miesiąc</h4></td>
        <td><h4>${Math.floor(vatBills * 100) / 100} zł</h4></td>
    </tr>
    <tr>
        <td><h4>Podatki związane z papierosami wynoszą średnio na miesiąc</h4></td>
        <td><h4>${Math.floor(vatCigarettes * 100) / 100} zł</h4></td>
    </tr>
    <tr>
        <td><h4>Podatki związane z rozrywką wynoszą średnio na miesiąc</h4></td>
        <td><h4>${Math.floor(vatEntertainment * 100) / 100} zł</h4></td>
    </tr>
    <tr>
        <td><h4>Podatki związane z zakupami towarów pierwszej potrzeby wynoszą średnio na miesiąc</h4></td>
        <td><h4>${Math.floor(vatGrocery * 100) / 100} zł</h4></td>
    </tr>
    <tr>
        <td><h4>Podatki związane z usługami wynoszą średnio na miesiąc</h4></td>
        <td><h4>${Math.floor(vatServices * 100) / 100} zł</h4></td>
    </tr>
    <tr>
        <td><h4>Podatek VAT wynosi Cię średnio co miesiąc</h4></td>
        <td><h4>${Math.floor(sumVat * 100) / 100} zł</h4></td>
    </tr>
</table>

<table>
    <tr><h2>Podsumowanie</h2></tr>
    <tr>
        <td><h2>Całkowita miesięczna kwota podatków to:</h2></td>
        <td><h2>${Math.floor(sum * 100) / 100} zł</h2></td>
    </tr>
    <tr>
        <td><h2>Całkowite roczne obciążenie podatkowe wynosi:</h2></td>
        <td><h2>${Math.floor(sumAnnual * 100) / 100} zł</h2></td>
    </tr>
    <tr>
        <td><h2>Stanowi to ${Math.floor(percentAnnual * 100) / 100}% Twoich rocznych dochodów.</h2></td>
    </tr>
</table>

<table>
    <tr>
        <td><a href="<c:url value="/formIncome"/>">Wypełnij nowy formularz odnośnie podatku dochodowego</a></td>
    </tr>
    <tr>
        <td><a href="<c:url value="/formVat"/>">Wypełnij nowy formularz odnośnie podatku VAT</a></td>
    </tr>
    <tr>
        <td><a href="<c:url value="/logout"/>">Wyloguj</a></td>
    </tr>
</table>

</body>
</html>
