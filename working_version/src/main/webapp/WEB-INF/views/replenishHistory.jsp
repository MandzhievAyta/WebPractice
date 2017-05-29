<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>ReplenishHistory Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add/Edit Replenish History
</h1>

<form action="http://localhost:8080/SpringMVCHibernate/clientsHome/">
    <input type="submit" value="Clients Page" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/tariffsHome/">
    <input type="submit" value="Tariffs Page" />
</form>
<c:url var="addAction" value="/replenishHistory/add" ></c:url>

<form:form action="${addAction}" commandName="replenishHistoryWithid">
    <table>
        <c:if test="${!empty replenishHistoryWithid.id}">
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
                <form:label path="amount">
                    <spring:message text="Amount"/>
                </form:label>
            </td>
            <td>
                <form:input path="amount" />
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
                <c:if test="${!empty replenishHistoryWithid.id}">
                    <input type="submit"
                           value="<spring:message text="Edit Replenish History"/>" />
                </c:if>
                <c:if test="${empty replenishHistoryWithid.id}">
                    <input type="submit"
                           value="<spring:message text="Add Replenish History"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Replenish History List</h3>
<c:if test="${!empty listReplenishHistory}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Date</th>
            <th width="120">Time</th>
            <th width="120">Amount</th>
            <th width="80">Account</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listReplenishHistory}" var="replenishHistory">
            <tr>
                <td>${replenishHistory.id}</td>
                <td>${replenishHistory.date}</td>
                <td>${replenishHistory.time}</td>
                <td>${replenishHistory.amount}</td>
                <td>${replenishHistory.account.id}</td>
                <td><a href="<c:url value='/replenishHistory/edit/${replenishHistory.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/replenishHistory/remove/${replenishHistory.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
