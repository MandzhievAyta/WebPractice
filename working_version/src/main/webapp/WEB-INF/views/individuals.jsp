<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Individuals Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add/Edit Individual clients
</h1>

<form action="http://localhost:8080/SpringMVCHibernate/clientsHome/">
    <input type="submit" value="Clients Page" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/tariffsHome/">
    <input type="submit" value="Tariffs Page" />
</form>
<c:url var="addAction" value="/individuals/add" ></c:url>

<form:form action="${addAction}" commandName="individualsWithid">
    <table>
        <c:if test="${!empty individualsWithid.id}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="First Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="secondName">
                    <spring:message text="Second Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="secondName" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty individualsWithid.id}">
                    <input type="submit"
                           value="<spring:message text="Edit Individual"/>" />
                </c:if>
                <c:if test="${empty individualsWithid.id}">
                    <input type="submit"
                           value="<spring:message text="Add Individual"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Individuals List</h3>
<c:if test="${!empty listIndividuals}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">First Name</th>
            <th width="120">Second Name</th>
            <th width="120">Client</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listIndividuals}" var="individuals">
            <tr>
                <td>${individuals.id}</td>
                <td>${individuals.firstName}</td>
                <td>${individuals.secondName}</td>
                <td>${individuals.client.id}</td>
                <td><a href="<c:url value='/individuals/edit/${individuals.id}' />" >Edit/Info</a></td>
                <td><a href="<c:url value='/individuals/remove/${individuals.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
