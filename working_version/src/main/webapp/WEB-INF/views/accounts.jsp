<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Accounts Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add/Edit Accounts
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
<br>
<h3>Accounts List</h3>
<c:if test="${!empty listAccounts}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Client</th>
            <th width="120">Balance</th>
            <th width="120">Max Debt</th>
            <th width="80">Pay Debt Date</th>
            <th width="60">Pay Debt Time</th>
            <th width="60">Phone Number</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listAccounts}" var="accounts">
            <tr>
                <td>${accounts.id}</td>
                <td>${accounts.client.id}</td>
                <td>${accounts.balance}</td>
                <td>${accounts.maxDebt}</td>
                <td>${accounts.payDebtDate}</td>
                <td>${accounts.payDebtTime}</td>
                <td>${accounts.phoneNumber}</td>
                <td><a href="<c:url value='/accounts/edit/${accounts.id}' />" >Edit/Info</a></td>
                <td><a href="<c:url value='/accounts/remove/${accounts.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
