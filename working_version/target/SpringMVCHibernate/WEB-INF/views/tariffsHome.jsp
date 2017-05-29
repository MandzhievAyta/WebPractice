<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Tariffs Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Tariffs Page
</h1>

<form action="http://localhost:8080/SpringMVCHibernate/clientsHome/">
    <input type="submit" value="Clients Page" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/tariffsHome/">
    <input type="submit" value="Tariffs Page" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/smsTariffs/">
    <input type="submit" value="Add/Edit Sms tariffs" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/internetTariffs/">
    <input type="submit" value="Add/Edit Internet tariffs" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/callTariffs/">
    <input type="submit" value="Add/Edit Call tariffs" />
</form>
<br>
<h3>Tariffs List</h3>
<h2>Internet tariffs:</h2>
<c:if test="${!empty listInternetTariffs}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Price</th>
        </tr>
        <c:forEach items="${listInternetTariffs}" var="internetTariffs">
            <tr>
                <td>${internetTariffs.id}</td>
                <td>${internetTariffs.name}</td>
                <td>${internetTariffs.price}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h2>Call tariffs:</h2>
<c:if test="${!empty listCallTariffs}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Price</th>
            <th width="120">Name</th>
            <th width="120">Group price</th>
        </tr>
        <c:forEach items="${listCallTariffs}" var="callTariffs">
            <tr>
                <td>${callTariffs.id}</td>
                <td>${callTariffs.price}</td>
                <td>${callTariffs.name}</td>
                <td>${callTariffs.group_price}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<h2>Sms tariffs:</h2>
<c:if test="${!empty listSmsTariffs}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Price</th>
            <th width="120">Group price</th>
        </tr>
        <c:forEach items="${listSmsTariffs}" var="smsTariffs">
            <tr>
                <td>${smsTariffs.id}</td>
                <td>${smsTariffs.name}</td>
                <td>${smsTariffs.price}</td>
                <td>${smsTariffs.group_price}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
