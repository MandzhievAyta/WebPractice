<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>WriteoffsHistory Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add/Edit Writeoffs History
</h1>

<form action="http://localhost:8080/SpringMVCHibernate/clientsHome/">
    <input type="submit" value="Clients Page" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/tariffsHome/">
    <input type="submit" value="Tariffs Page" />
</form>
<c:url var="addAction" value="/writeoffsHistory/add" ></c:url>

<form:form action="${addAction}" commandName="writeoffsHistoryWithid">
    <table>
        <c:if test="${!empty writeoffsHistoryWithid.id}">
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
                <form:label path="date">
                    <spring:message text="Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="date" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="time">
                    <spring:message text="Time"/>
                </form:label>
            </td>
            <td>
                <form:input path="time" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="value">
                    <spring:message text="Value"/>
                </form:label>
            </td>
            <td>
                <form:input path="value" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="contractsHistoryId">
                    <spring:message text="Contracts History"/>
                </form:label>
            </td>
            <td>
                <form:input path="contractsHistoryId" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="accountId">
                    <spring:message text="Account"/>
                </form:label>
            </td>
            <td>
                <form:input path="accountId" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty writeoffsHistoryWithid.id}">
                    <input type="submit"
                           value="<spring:message text="Edit Writeoff's History"/>" />
                </c:if>
                <c:if test="${empty writeoffsHistoryWithid.id}">
                    <input type="submit"
                           value="<spring:message text="Add Writeoff's History"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Writeoffs History List</h3>
<c:if test="${!empty listWriteoffsHistory}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Date</th>
            <th width="120">Time</th>
            <th width="120">Value</th>
            <th width="80">Contracts History</th>
            <th width="60">Account</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listWriteoffsHistory}" var="writeoffsHistory">
            <tr>
                <td>${writeoffsHistory.id}</td>
                <td>${writeoffsHistory.date}</td>
                <td>${writeoffsHistory.time}</td>
                <td>${writeoffsHistory.value}</td>
                <td>${writeoffsHistory.contractsHistory.id}</td>
                <td>${writeoffsHistory.account.id}</td>
                <td><a href="<c:url value='/writeoffsHistory/edit/${writeoffsHistory.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/writeoffsHistory/remove/${writeoffsHistory.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
