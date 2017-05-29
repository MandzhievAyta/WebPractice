<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>NumberGroups Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add/Edit Numbers groups
</h1>

<form action="http://localhost:8080/SpringMVCHibernate/clientsHome/">
    <input type="submit" value="Clients Page" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/tariffsHome/">
    <input type="submit" value="Tariffs Page" />
</form>
<c:url var="addAction" value="/numberGroups/add" ></c:url>

<form:form action="${addAction}" commandName="numberGroupsWithid">
    <table>
        <c:if test="${!empty numberGroupsWithid.id}">
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
                <form:label path="accountId">
                    <spring:message text="Account Id"/>
                </form:label>
            </td>
            <td>
                <form:input path="accountId" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="groupNumber">
                    <spring:message text="Group Number"/>
                </form:label>
            </td>
            <td>
                <form:input path="groupNumber" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty numberGroupsWithid.id}">
                    <input type="submit"
                           value="<spring:message text="Edit Group number"/>" />
                </c:if>
                <c:if test="${empty numberGroupsWithid.id}">
                    <input type="submit"
                           value="<spring:message text="Add Group number"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Number Groups List</h3>
<c:if test="${!empty listNumberGroups}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Account</th>
            <th width="120">Group Number</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listNumberGroups}" var="numberGroups">
            <tr>
                <td>${numberGroups.id}</td>
                <td>${numberGroups.account.id}</td>
                <td>${numberGroups.groupNumber}</td>
                <td><a href="<c:url value='/numberGroups/edit/${numberGroups.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/numberGroups/remove/${numberGroups.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
