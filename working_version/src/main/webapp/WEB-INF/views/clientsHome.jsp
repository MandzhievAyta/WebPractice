<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Clients Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Clients Page
</h1>

<form action="http://localhost:8080/SpringMVCHibernate/clientsHome/">
    <input type="submit" value="Clients Page" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/tariffsHome/">
    <input type="submit" value="Tariffs Page" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/numberGroups/">
    <input type="submit" value="Groups of Numbers" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/individuals/">
    <input type="submit" value="Add/Edit Individual clients" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/organizations/">
    <input type="submit" value="Add/Edit Organizations" />
</form>
<br>
<h3>Clients List</h3>

<h2>Organizations:</h2>
<c:if test="${!empty listOrganizations}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Client</th>
        </tr>
        <c:forEach items="${listOrganizations}" var="organizations">
            <tr>
                <td>${organizations.id}</td>
                <td>${organizations.name}</td>
                <td>${organizations.client.id}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h2>Individual clients</h2>
<c:if test="${!empty listIndividuals}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">First Name</th>
            <th width="120">Second Name</th>
            <th width="120">Client</th>
        </tr>
        <c:forEach items="${listIndividuals}" var="individuals">
            <tr>
                <td>${individuals.id}</td>
                <td>${individuals.firstName}</td>
                <td>${individuals.secondName}</td>
                <td>${individuals.client.id}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
