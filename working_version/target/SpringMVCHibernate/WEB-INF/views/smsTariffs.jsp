<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sms Tariffs Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
    <h1>
        Add/Edit Sms Tariffs
    </h1>

    <form action="http://localhost:8080/SpringMVCHibernate/clientsHome/">
        <input type="submit" value="Clients Page" />
    </form>
    <form action="http://localhost:8080/SpringMVCHibernate/tariffsHome/">
        <input type="submit" value="Tariffs Page" />
    </form>
    <c:url var="addAction" value="/smsTariffs/add" ></c:url>

    <form:form action="${addAction}" commandName="smsTariffs">
        <table>
            <c:if test="${!empty smsTariffs.id}">
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
                    <form:label path="name">
                        <spring:message text="Name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="name" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="price">
                        <spring:message text="Price"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="price" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="group_price">
                        <spring:message text="Group price"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="group_price" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty smsTariffs.id}">
                        <input type="submit"
                               value="<spring:message text="Edit SmsTariffs"/>" />
                    </c:if>
                    <c:if test="${empty smsTariffs.id}">
                        <input type="submit"
                               value="<spring:message text="Add SmsTariffs"/>" />
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
    <br>
    <h3>Sms Tariffs List</h3>
    <c:if test="${!empty listSmsTariffs}">
        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">Name</th>
                <th width="120">Price</th>
                <th width="120">Group price</th>
                <th width="60">Edit</th>
                <th width="60">Delete</th>
            </tr>
            <c:forEach items="${listSmsTariffs}" var="smsTariffs">
                <tr>
                    <td>${smsTariffs.id}</td>
                    <td>${smsTariffs.name}</td>
                    <td>${smsTariffs.price}</td>
                    <td>${smsTariffs.group_price}</td>
                    <td><a href="<c:url value='/smsTariffs/edit/${smsTariffs.id}' />" >Edit</a></td>
                    <td><a href="<c:url value='/smsTariffs/remove/${smsTariffs.id}' />" >Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
