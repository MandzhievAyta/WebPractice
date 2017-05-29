<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>ContractsHistory Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add/Edit Contracts History
</h1>

<form action="http://localhost:8080/SpringMVCHibernate/clientsHome/">
    <input type="submit" value="Clients Page" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/tariffsHome/">
    <input type="submit" value="Tariffs Page" />
</form>
<c:url var="addAction" value="/contractsHistory/add" ></c:url>

<form:form action="${addAction}" commandName="contractsHistoryWithid">
    <table>
        <c:if test="${!empty contractsHistoryWithid.id}">
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
                <form:label path="callTariffId">
                    <spring:message text="Call Tariff Id"/>
                </form:label>
            </td>
            <td>
                <form:input path="callTariffId" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="smsTariffId">
                    <spring:message text="Sms Tariff Id"/>
                </form:label>
            </td>
            <td>
                <form:input path="smsTariffId" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="internetTariffId">
                    <spring:message text="Internet Tariff Id"/>
                </form:label>
            </td>
            <td>
                <form:input path="internetTariffId" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="relevance">
                    <spring:message text="Relevance"/>
                </form:label>
            </td>
            <td>
                <form:input path="relevance" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="tariffType">
                    <spring:message text="Tariff Type"/>
                </form:label>
            </td>
            <td>
                <form:input path="tariffType" />
            </td>
        </tr>
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
            <td colspan="2">
                <c:if test="${!empty contractsHistoryWithid.id}">
                    <input type="submit"
                           value="<spring:message text="Edit Contract's History"/>" />
                </c:if>
                <c:if test="${empty contractsHistoryWithid.id}">
                    <input type="submit"
                           value="<spring:message text="Add Contract's History"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Contracts History List</h3>
<c:if test="${!empty listContractsHistory}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Account</th>
            <th width="120">Call tariff</th>
            <th width="120">Sms tariff</th>
            <th width="80">Internet tariff</th>
            <th width="60">Relevance</th>
            <th width="60">Tariff type</th>
            <th width="60">Date</th>
            <th width="60">Time</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listContractsHistory}" var="contractsHistory">
            <tr>
                <td>${contractsHistory.id}</td>
                <td>${contractsHistory.account.id}</td>
                <td>${contractsHistory.callTariff.name}</td>
                <td>${contractsHistory.smsTariff.name}</td>
                <td>${contractsHistory.internetTariff.name}</td>
                <td>${contractsHistory.relevance}</td>
                <td>${contractsHistory.tariffType}</td>
                <td>${contractsHistory.date}</td>
                <td>${contractsHistory.time}</td>
                <td><a href="<c:url value='/contractsHistory/edit/${contractsHistory.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/contractsHistory/remove/${contractsHistory.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
