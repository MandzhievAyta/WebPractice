<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Contacts Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add/Edit Contacts
</h1>

<form action="http://localhost:8080/SpringMVCHibernate/clientsHome/">
    <input type="submit" value="Clients Page" />
</form>
<form action="http://localhost:8080/SpringMVCHibernate/tariffsHome/">
    <input type="submit" value="Tariffs Page" />
</form>
<c:url var="addAction" value="/contacts/add" ></c:url>

<form:form action="${addAction}" commandName="contactsWithid">
    <table>
        <c:if test="${!empty contactsWithid.id}">
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
                    <spring:message text="Client"/>
                </form:label>
            </td>
            <td>
                <form:input path="clientId" />
            </td>
        </tr>
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
            <td>
                <form:label path="address">
                    <spring:message text="Address"/>
                </form:label>
            </td>
            <td>
                <form:input path="address" />
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
            <td>
                <form:label path="mail">
                    <spring:message text="Mail"/>
                </form:label>
            </td>
            <td>
                <form:input path="mail" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty contactsWithid.id}">
                    <input type="submit"
                           value="<spring:message text="Edit Contact"/>" />
                </c:if>
                <c:if test="${empty contactsWithid.id}">
                    <input type="submit"
                           value="<spring:message text="Add Contact"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Contacts List</h3>
<c:if test="${!empty listContacts}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Client</th>
            <th width="120">First name</th>
            <th width="120">Second name</th>
            <th width="80">Address</th>
            <th width="60">Phone Number</th>
            <th width="60">Mail</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listContacts}" var="contacts">
            <tr>
                <td>${contacts.id}</td>
                <td>${contacts.client.id}</td>
                <td>${contacts.firstName}</td>
                <td>${contacts.secondName}</td>
                <td>${contacts.address}</td>
                <td>${contacts.phoneNumber}</td>
                <td>${contacts.mail}</td>
                <td><a href="<c:url value='/contacts/edit/${contacts.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/contacts/remove/${contacts.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
