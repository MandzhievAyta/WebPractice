<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Account Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Information about an account
</h1>

<form action="http://localhost:8080/SpringMVCHibernate/clientsHome/">
    <input type="submit" value="Clients Page" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/tariffsHome/">
    <input type="submit" value="Tariffs Page" />
</form>
<c:url var="addAction" value="/accounts/add" ></c:url>

<form:form action="${addAction}" commandName="accountsWithid">
<table>
    <c:if test="${!empty accountsWithid.id}">
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
            <form:label path="clientId">
                <spring:message text="Client's Id"/>
            </form:label>
        </td>
        <td>
            <form:input path="clientId" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="balance">
                <spring:message text="Balance"/>
            </form:label>
        </td>
        <td>
            <form:input path="balance" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="maxDebt">
                <spring:message text="Max Debt"/>
            </form:label>
        </td>
        <td>
            <form:input path="maxDebt" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="payDebtDate">
                <spring:message text="Pay Debt Date"/>
            </form:label>
        </td>
        <td>
            <form:input path="payDebtDate" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="payDebtTime">
                <spring:message text="Pay Debt Time"/>
            </form:label>
        </td>
        <td>
            <form:input path="payDebtTime" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="phoneNumber">
                <spring:message text="Phone Number"/>
            </form:label>
        </td>
        <td>
            <form:input path="phoneNumber" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty accountsWithid.id}">
                <input type="submit"
                       value="<spring:message text="Edit Account"/>" />
            </c:if>
            <c:if test="${empty accountsWithid.id}">
                <input type="submit"
                       value="<spring:message text="Add Account"/>" />
            </c:if>
        </td>
    </tr>
</table>
</form:form>


<h3>Contracts History of current account:</h3>
<form action="http://localhost:8080/SpringMVCHibernate/contractsHistory/">
    <input type="submit" value="Add contract" />
</form>
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

<h3>Replenish History of current account:</h3>
<form action="http://localhost:8080/SpringMVCHibernate/replenishHistory/">
    <input type="submit" value="Add replenish" />
</form>
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

<h3>Writeoffs History of current account:</h3>
<form action="http://localhost:8080/SpringMVCHibernate/writeoffsHistory/">
    <input type="submit" value="Add writeoff" />
</form>
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

